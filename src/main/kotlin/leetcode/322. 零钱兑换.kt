package leetcode

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
你可以认为每种硬币的数量是无限的。

示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

示例 2：
输入：coins = [2], amount = 3
输出：-1

示例 3：
输入：coins = [1], amount = 0
输出：0

示例 4：
输入：coins = [1], amount = 1
输出：1

示例 5：
输入：coins = [1], amount = 2
输出：2
 
提示：
1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { -1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (coin in coins) {
            if (i - coin < 0 || dp[i - coin] == -1) {
                continue
            }
            if (dp[i] == -1) {
                dp[i] = dp[i - coin] + 1
            } else {
                dp[i] = minOf(dp[i], dp[i - coin] + 1)
            }
        }
    }
    return dp[amount]
}

fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
    println(coinChange(intArrayOf(2), 3))
    println(coinChange(intArrayOf(1), 0))
    println(coinChange(intArrayOf(1), 1))
}

/*
dp[1] -> 1
dp[2] -> 1
dp[5] -> 1
dp[2] -> minOf(1, dp[1])
dp[3] ->
 */