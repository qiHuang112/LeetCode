package leetcode

/*
给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
重复出现的子串要计算它们出现的次数。

示例 1 :
输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
请注意，一些重复出现的子串要计算它们出现的次数。
另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。

示例 2 :
输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。

注意：
s.length 在1到50,000之间。
s 只包含“0”或“1”字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-binary-substrings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 中心往两边扩散
 */
private fun countBinarySubstrings1(s: String): Int {
    var count = 0
    for (i in 1..s.lastIndex) {
        if (s[i - 1] != s[i]) {
            count++
            var (left, right) = i - 1 to i
            while (left - 1 >= 0 && right + 1 < s.length && s[left] == s[left - 1] && s[right] == s[right + 1]) {
                count++
                left--
                right++
            }
        }
    }
    return count
}

/**
 * 每次取相邻个数的最小值，累加
 */
private fun countBinarySubstrings(s: String): Int {
    var lastCount = 0
    var curCount = 0
    var cur = ' '
    var res = 0
    for (c in "$s ") {
        when (c) {
            cur -> curCount++
            else -> {
                res += minOf(lastCount, curCount)
                lastCount = curCount
                curCount = 1
                cur = c
            }
        }
    }
    return res
}

fun main() {
    println(countBinarySubstrings("00110011"))
    println(countBinarySubstrings("10101"))
    println(countBinarySubstrings("110100011110"))
}
/*
"00110011" -> 2+2+2
"1101011" -> 1+1+1+1
110100011110 -> 1+1+1+3+1
 */