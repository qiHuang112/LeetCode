package leetcode

/*
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:
输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路，分成三段
 */
private fun shortestToChar(S: String, C: Char): IntArray {
    val left = S.indexOf(C)
    val right = S.lastIndexOf(C)
    val res = IntArray(S.length)
    // 左边
    for (i in 0 until left) {
        res[i] = left - i
    }
    // 右边
    for (i in right until res.size) {
        res[i] = i - right
    }
    // 中间
    var cur = left
    for (i in left + 1..right) {
        if (S[i] == C) {
            for (j in cur + 1..(cur + i) / 2) {
                res[j] = j - cur
                res[cur + i - j] = j - cur
            }
            cur = i
        }
    }
    return res
}

fun main() {
    println(shortestToChar(S = "loveleetcode", C = 'e').contentToString())
}