package leetcode

/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。

示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力 o(n²)
 */
private fun maxProfit1(prices: IntArray): Int {
    var res = 0
    for (i in prices.indices) {
        if (i - 1 >= 0 && prices[i] > prices[i - 1]) {
            continue
        }
        for (j in i + 1..prices.lastIndex) {
            res = maxOf(res, prices[j] - prices[i])
        }
    }
    return res
}

/**
 * 动态规划 o(n)
 * dp[i] 表示前 i 天股价最低的一天，则
 * dp[i] = minOf(dp[i-1], nums[i])
 * res = maxOf(res, nums[i] - dp[i])
 *
 * 由于每次使用仅用了上一次天的值，所以可以去掉数组，将空间复杂度从o(n)简化为o(1)
 */
private fun maxProfit(prices: IntArray): Int {
    var min = Int.MAX_VALUE
    var res = 0
    for (price in prices) {
        res = maxOf(res, price - min)
        min = minOf(min, price)
    }
    return res
}

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}