package leetcode

/*
给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
提示：a + b 意味着字符串 a 和 b 连接。

示例 1：
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true

示例 2：
输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false

示例 3：
输入：s1 = "", s2 = "", s3 = ""
输出：true
 
提示：
0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1、s2、和 s3 都由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/interleaving-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 贪心
 */
private fun isInterleave1(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length) return false
    return isInterleave1(s1, 0, s2, 0, s3, 0)
}

private fun isInterleave1(s1: String, i1: Int, s2: String, i2: Int, s3: String, i3: Int): Boolean {
    if (i3 == s3.length) return true
    if (i1 == s1.length) return s2[i2] == s3[i3] && isInterleave1(s1, i1, s2, i2 + 1, s3, i3 + 1)
    if (i2 == s2.length) return s1[i1] == s3[i3] && isInterleave1(s1, i1 + 1, s2, i2, s3, i3 + 1)
    if (s1[i1] != s3[i3] && s2[i2] != s3[i3]) return false
    if (s1[i1] != s3[i3]) return isInterleave1(s1, i1, s2, i2 + 1, s3, i3 + 1)
    if (s2[i2] != s3[i3]) return isInterleave1(s1, i1 + 1, s2, i2, s3, i3 + 1)
    return isInterleave1(s1, i1, s2, i2 + 1, s3, i3 + 1) || isInterleave1(s1, i1 + 1, s2, i2, s3, i3 + 1)
}

/**
 * 动态规划
 * 设dp[i][j]表示s1中取i个s2中取j个  是否能拼成s3的前i+j个，那么有
 * dp[0][0] = true
 * dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i+j-1]) || (dp[i][j-1] && s2[j-1] == s3[i+j-1])
 */
private fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length) return false
    val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }
    dp[0][0] = true
    for (i in 1..s1.length) {
        dp[i][0] = dp[i - 1][0] && s1[i - 1] == s3[i - 1]
    }
    for (i in 1..s2.length) {
        dp[0][i] = dp[0][i - 1] && s2[i - 1] == s3[i - 1]
    }
    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1])
        }
    }
    return dp[s1.length][s2.length]
}

fun main() {
    isInterleave(s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac").let(::println)
    isInterleave(s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc").let(::println)
    isInterleave(s1 = "", s2 = "", s3 = "").let(::println)
}