package leetcode

import kotlin.math.min

/**
编写一个程序，找出第 n 个丑数。

丑数就是质因数只包含 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
private fun nthUglyNumber(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[1] = 1
    // 构建下一个最小丑数可能用到的数的索引
    var (p2, p3, p5) = arrayOf(1, 1, 1)
    for (i in 2..n) {
        dp[i] = minOf(2 * dp[p2], 3 * dp[p3], 5 * dp[p5])
        // 更新当前最小丑数的索引（用过了的就往下走）
        if (dp[i] == 2 * dp[p2]) p2++
        if (dp[i] == 3 * dp[p3]) p3++
        if (dp[i] == 5 * dp[p5]) p5++
    }
    return dp[n]
}

fun main() {
    for (i in 1..20) {
        println(nthUglyNumber(i))
    }
}