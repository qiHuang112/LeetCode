package leetcode

/*
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。
上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

示例:

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
说明:

你可以假设矩阵不可变。
会多次调用 sumRegion 方法。
你可以假设 row1 ≤ row2 且 col1 ≤ col2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class NumMatrix(matrix: Array<IntArray>) {
    var dp: Array<IntArray> = emptyArray()
    var isEmpty = false

    init {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            isEmpty = true
        } else {
            // 加哨兵
            dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
            // 根据matrix初始化dp数组
            for (i in 1..dp.lastIndex) {
                for (j in 1..dp[i].lastIndex) {
                    dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
                }
            }
            dp.map(IntArray::contentToString).forEach(::println)
        }
    }

    /**
     * 划分成四个dp值，
     */
    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1]
    }
}

fun main() {
    NumMatrix(
        arrayOf(
            intArrayOf(3, 0, 1, 4, 2),
            intArrayOf(5, 6, 3, 2, 1),
            intArrayOf(1, 2, 0, 1, 5),
            intArrayOf(4, 1, 0, 1, 7),
            intArrayOf(1, 0, 3, 0, 5),
        )
    ).apply {
        println(sumRegion(2, 1, 4, 3))
        println(sumRegion(1, 1, 2, 2))
        println(sumRegion(1, 2, 2, 4))
    }
    NumMatrix(
        arrayOf(
            intArrayOf(-4, -5),
        )
    ).apply {
        println(sumRegion(0, 0, 0, 0))
        println(sumRegion(0, 0, 0, 1))
        println(sumRegion(0, 1, 0, 1))
    }
}