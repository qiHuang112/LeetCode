package leetcode

/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

进阶：
如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

示例 1：
输入：s = "abc", t = "ahbgdc"
输出：true

示例 2：
输入：s = "axc", t = "ahbgdc"
输出：false

提示：
0 <= s.length <= 100
0 <= t.length <= 10^4
两个字符串都只由小写字符组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isSubsequence1(s: String, t: String): Boolean {
    return isSubsequence(s.toCharArray(), 0, s.lastIndex, t.toCharArray(), 0, t.lastIndex)
}

/**
 * 贪心
 */
private fun isSubsequence(
    charS: CharArray,
    leftS: Int,
    rightS: Int,
    charT: CharArray,
    leftT: Int,
    rightT: Int
): Boolean {
    // 空字符串是任何字符串的子串
    if (leftS > rightS) return true
    // 子串长度大于父串 肯定不是子串
    if (rightS - leftS > rightT - leftT) return false
    // 找到每一个匹配当前charS[leftS]的节点，并递归
    for (i in leftT..rightT) {
        if (charT[i] == charS[leftS] && isSubsequence(charS, leftS + 1, rightS, charT, i + 1, rightT)) {
            return true
        }
    }
    // 父串中没找到charS[leftS]
    return false
}

/**
 * 双指针
 */
private fun isSubsequence2(s: String, t: String): Boolean {
    var (left, right) = 0 to s.lastIndex
    var (leftT, rightT) = 0 to t.lastIndex
    while (left <= right) {
        while (leftT <= rightT && s[left] != t[leftT]) {
            leftT++
        }
        while (leftT <= rightT && s[right] != t[rightT]) {
            rightT--
        }
        if (right - left > rightT - leftT || leftT++ > rightT--) {
            return false
        }
        left++
        right--
    }
    return true
}

/**
 * 别人家的双指针
 */
private fun isSubsequence(s: String, t: String): Boolean {
    var (si, ti) = 0 to 0
    while (si < s.length) {
        if (ti == t.length) return false
        if (s[si] == t[ti]) {
            si++
            ti++
        } else {
            ti++
        }
    }
    return true
}

fun main() {
    println(isSubsequence(s = "bb", t = "ahbgdc"))
    println(isSubsequence(s = "abc", t = "ahbgdc"))
    println(isSubsequence(s = "axc", t = "ahbgdc"))
    println(isSubsequence(s = "abc", t = "ahbdabgdc"))
}

