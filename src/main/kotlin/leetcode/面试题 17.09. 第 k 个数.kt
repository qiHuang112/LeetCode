package leetcode

/*
有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

示例 1:
输入: k = 5
输出: 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 动态规划
 * 设dp[i]表示第i个数字，那么有
 * dp[1] = 1
 *
 */
private fun getKthMagicNumber(k: Int): Int {
    val dp = IntArray(k + 1)
    dp[1] = 1
    // p3,p5,p7分别指向构建下一个数可能用到的最小索引
    var (p3, p5, p7) = arrayOf(1, 1, 1)
    for (i in 2..k) {
        dp[i] = minOf(3 * dp[p3], 5 * dp[p5], 7 * dp[p7])
        if (dp[i] == 3 * dp[p3]) p3++
        if (dp[i] == 5 * dp[p5]) p5++
        if (dp[i] == 7 * dp[p7]) p7++
    }
    return dp[k]
}

fun main() {
    for (i in 1..10) {
        println(getKthMagicNumber(i))
    }
}