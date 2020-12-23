package leetcode

/*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。

示例 1：
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右

示例 2：
输入：obstacleGrid = [[0,1],[0,0]]
输出：1

提示：
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 动态规划
 */
private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid.last().last() == 1) return 0
    val dp = Array(obstacleGrid.size) { (IntArray(obstacleGrid[0].size)) }
    dp[dp.lastIndex][dp[0].lastIndex] = 1
    for (i in dp.lastIndex - 1 downTo 0) {
        dp[i][dp[0].lastIndex] = if (obstacleGrid[i][dp[0].lastIndex] == 1) 0 else dp[i + 1][dp[0].lastIndex]
    }
    for (i in dp[0].lastIndex - 1 downTo 0) {
        dp[dp.lastIndex][i] = if (obstacleGrid[dp.lastIndex][i] == 1) 0 else dp[dp.lastIndex][i + 1]
    }
    for (i in dp.lastIndex - 1 downTo 0) {
        for (j in dp[0].lastIndex - 1 downTo 0) {
            dp[i][j] = if (obstacleGrid[i][j] == 1) 0 else dp[i + 1][j] + dp[i][j + 1]
        }
    }
    return dp[0][0]
}

fun main() {
    println(
        uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0),
            )
        )
    )
    println(
        uniquePathsWithObstacles(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 0),
            )
        )
    )
}