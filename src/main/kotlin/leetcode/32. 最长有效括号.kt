package leetcode

/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"

示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 设dp[i]表示以i结尾，可能组成有效括号的长度:则有
 */
private fun longestValidParentheses(s: String): Int {
    val dp = IntArray(s.length)
    var res = 0
    for (i in s.indices) {
        when (s[i]) {
            '(' -> dp[i] = 0
            ')' -> {
                if (i > 0) {
                    if (s[i - 1] == '(') {
                        dp[i] = if (i > 1) dp[i - 2] + 2 else 2
                    } else {
                        if (i - dp[i - 1] > 0 && s[i - dp[i - 1] - 1] == '(') {
                            dp[i] = dp[i - 1] + 2 + if (i - dp[i - 1] - 1 > 0) dp[i - dp[i - 1] - 2] else 0
                        } else {
                            dp[i] = 0
                        }
                    }
                } else {
                    dp[i] = 0
                }
            }
        }
        res = maxOf(res, dp[i])
    }
    return res
}

fun main() {
    println(longestValidParentheses("(()"))
    println(longestValidParentheses("(()()"))
    println(longestValidParentheses(")()())"))
    println(longestValidParentheses("()(()"))
    println(longestValidParentheses("()(())"))

}