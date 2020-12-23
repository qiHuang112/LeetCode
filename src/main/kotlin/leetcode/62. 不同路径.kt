package leetcode

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？

示例 1：
输入：m = 3, n = 7
输出：28

示例 2：
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右

示例 3：
输入：m = 7, n = 3
输出：28

示例 4：
输入：m = 3, n = 3
输出：6

提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 动态规划：
 * 设dp[i][j] 为从点(0,0)到点(i,j)的路径数
 * 则所求即dp[m-1][n-1]
 * dp[0][i] = 1 其中 i -> [0,n-1]
 * dp[i][0] = 1 其中 i -> [0,m-1]
 * dp[i][j] = dp[i-1][j] + dp[i][j-1] 其中 i -> [1,m-1], j -> [1,n-1]
 */
private fun uniquePaths1(m: Int, n: Int): Int {
    val dp = Array(m) { IntArray(n) }
    for (i in 0 until n) {
        dp[0][i] = 1
    }
    for (i in 0 until m) {
        dp[i][0] = 1
    }
    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    return dp[m - 1][n - 1]
}

/**
 * 方法2：组合
 * 一共需要移动 m+n-2次，选出 m-1次向右
 * 结果为 C(m-1, m+n-2)
 * 利用公式C(m,n) = (n!)/(m!)((n-m)!)
 */
private fun uniquePaths(m: Int, n: Int): Int {
    return combine(m - 1, n + m - 2).toInt()
}

private fun combine(m: Int, n: Int): Long {
    if (m < 0 || n < 0 || m > n) return 0
    if (m * 2 < n) return combine(n - m, n)
    var res = 1L
    for (i in 1..n - m) {
        res = res * (m + i) / i
    }
    return res
}

fun main() {
    println(uniquePaths(m = 3, n = 7))
    println(uniquePaths(m = 3, n = 2))
    println(uniquePaths(m = 7, n = 3))
    println(uniquePaths(m = 3, n = 3))
}