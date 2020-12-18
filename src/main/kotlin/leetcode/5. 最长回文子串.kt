package leetcode

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：
输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。

示例 2：
输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * 1.讨论奇数
 * 分别以每个index为中间节点，向两边扩展 讨论范围为 0~s.lastIndex
 * 2.讨论偶数
 * 分别以当前节点和下一个为中间节点，向两边扩展，讨论范围为 (0,1) ~ (s.lastIndex-1,s.lastIndex)
 *
 * 公共方法：在[i,j]已经是回文串的时候，向两边扩展，范围最大回文串
 */
private fun longestPalindrome(s: String): String {
    val getMax = { charArray: CharArray, left: Int, right: Int ->
        var res = 0
        while (left - res >= 0 && right + res < charArray.size && charArray[left - res] == charArray[right + res]) {
            res++
        }
        res
    }
    val arr = s.toCharArray()
    var max = 0
    var res = 0..0
    for (i in s.indices) {
        val cur = getMax(arr, i, i)
        val curMax = 2 * cur - 1
        if (curMax > max) {
            max = curMax
            res = i - cur + 1 until i + cur
        }
    }
    for (i in 0 until s.lastIndex) {
        val cur = getMax(arr, i, i + 1)
        val curMax = 2 * cur
        if (curMax > max) {
            max = curMax
            res = i - cur + 1..i + cur
        }
    }
    return s.substring(res)
}

fun main() {
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("abbdcdbda"))
}