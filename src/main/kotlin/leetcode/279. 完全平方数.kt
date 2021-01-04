package leetcode

/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:
输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.

示例 2:
输入: n = 13
输出: 2
解释: 13 = 4 + 9.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：dp
 * 联想到题目：用面值为(1,2,5)的零钱凑 11块，而这里的零钱就是完全平方数
 * 首先需要做的是根据n初始化零钱
 * 然后用dp
 */
private fun numSquares1(n: Int): Int {
    val coins = mutableListOf<Int>()
    var index = 1
    while (index * index <= n) {
        coins.add(index * index)
        index++
    }
    val dp = IntArray(n + 1) { -1 }
    dp[0] = 0
    for (i in 1..n) {
        for (coin in coins) {
            if (i - coin < 0 || dp[i - coin] == -1) continue
            dp[i] = if (dp[i] == -1) 1 + dp[i - coin] else minOf(dp[i], dp[i - coin] + 1)
        }
    }
    return dp[n]
}

/**
 * 简化下上面的代码
 */
private fun numSquares(n: Int): Int {
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in 1..n) {
        var j = 1
        while (i - j * j >= 0) {
            dp[i] = minOf(dp[i], dp[i - j * j] + 1)
            j++
        }
    }
    return dp[n]
}

fun main() {
    println(numSquares(12))
    println(numSquares(13))
}