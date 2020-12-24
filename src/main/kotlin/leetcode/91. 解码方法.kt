package leetcode

/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。
题目数据保证答案肯定是一个 32 位的整数。

示例 1：
输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。

示例 2：
输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

示例 3：
输入：s = "0"
输出：0

示例 4：
输入：s = "1"
输出：1

示例 5：
输入：s = "2"
输出：1
 
提示：
1 <= s.length <= 100
s 只包含数字，并且可能包含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun numDecodings(s: String): Int {
    if (s.isEmpty() || s[0] == '0') return 0
    val dp = IntArray(s.length)
    dp[0] = 1
    for (i in 1..dp.lastIndex) {
        // 0~i-2 要求s[i-1] != 0 && s[i-1] *10 + s[i] <= 26 取 dp[i-2]的值 否则取0
        val a = if (s[i - 1] != '0' && (s[i - 1] - '0') * 10 + (s[i] - '0') <= 26) if (i >= 2) dp[i - 2] else 1 else 0
        // 0~i-1 要求s[i] != 0 取dp[i-1]的值 否则取0
        val b = if (s[i] != '0') dp[i - 1] else 0
        dp[i] = a + b
    }
    return dp.last()
}

fun main() {
    println(numDecodings("12"))
    println(numDecodings("226"))
    println(numDecodings("0"))
    println(numDecodings("1"))
    println(numDecodings("2"))
    println(numDecodings("121321"))
    println(numDecodings("10"))
}
/*
1 2 1 0 2 1
1 2 10 2 1

 */