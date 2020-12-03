package leetcode

/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * dfs超时了
 */
private fun minimumTotal1(triangle: List<List<Int>>): Int {
    var res = Int.MAX_VALUE
    fun dfs(i: Int, j: Int, cur: Int) {
        if (i !in triangle.indices || j !in triangle[i].indices) {
            res = minOf(res, cur)
            return
        }
        dfs(i + 1, j, cur + triangle[i][j])
        dfs(i + 1, j + 1, cur + triangle[i][j])
    }
    dfs(0, 0, 0)
    return res
}

/**
 * 考虑用动态规划空间换时间
 */
private fun minimumTotal(triangle: List<List<Int>>): Int {
    val dp = MutableList(triangle.size) { i ->
        triangle[i].toMutableList()
    }
    for (i in dp.indices) {
        for (j in dp[i].indices) {
            dp[i][j] += when {
                i == 0 -> 0
                j == 0 -> dp[i - 1][j]
                j == dp[i - 1].size -> dp[i - 1][j - 1]
                else -> {
                    minOf(dp[i - 1][j], dp[i - 1][j - 1])
                }
            }
        }
    }
    return dp.last().reduce(Math::min)
}

fun main() {
    println(
        minimumTotal(
            listOf(
                listOf(2),
                listOf(3, 4),
                listOf(6, 5, 7),
                listOf(4, 1, 8, 3),
            )
        )
    )
}