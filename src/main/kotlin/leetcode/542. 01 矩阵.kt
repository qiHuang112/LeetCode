package leetcode

/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。

示例 1：
输入：
[[0,0,0],
 [0,1,0],
 [0,0,0]]

输出：
[[0,0,0],
 [0,1,0],
 [0,0,0]]

示例 2：
输入：
[[0,0,0],
 [0,1,0],
 [1,1,1]]

输出：
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 
提示：
给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/01-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * dfs
 */
private fun updateMatrix1(matrix: Array<IntArray>): Array<IntArray> {
    val map = Array(matrix.size) { BooleanArray(matrix[0].size) }
    fun dfs(i: Int, j: Int, distance: Int) {
        if (i !in matrix.indices || j !in matrix[i].indices) {
            return
        }
        // 遍历过这个点
        if (map[i][j]) {
            // 但是现在有更近的
            if (matrix[i][j] > distance) {
                matrix[i][j] = distance
//                println("matrix[$i][$j] = $distance")
                dfs(i + 1, j, distance + 1)
                dfs(i, j + 1, distance + 1)
                dfs(i - 1, j, distance + 1)
                dfs(i, j - 1, distance + 1)
            }
        } else {
            map[i][j] = true
            if (matrix[i][j] != 0) {
//                println("matrix[$i][$j] = $distance")
                matrix[i][j] = distance
            }
            dfs(i + 1, j, matrix[i][j] + 1)
            dfs(i, j + 1, matrix[i][j] + 1)
            dfs(i - 1, j, matrix[i][j] + 1)
            dfs(i, j - 1, matrix[i][j] + 1)
        }
    }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == 0) {
                dfs(i, j, 0)
            }
        }
    }
    return matrix
}

/**
 * dp
 */
private fun updateMatrix(matrix: Array<IntArray>): Array<IntArray> {
    val row = matrix.size
    val col = matrix[0].size

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = row + col
            }
            if (i > 0) {
                matrix[i][j] = minOf(matrix[i][j], matrix[i - 1][j] + 1)
            }
            if (j > 0) {
                matrix[i][j] = minOf(matrix[i][j], matrix[i][j - 1] + 1)
            }
        }
    }
    for (i in row downTo 1) {
        for (j in col downTo 1) {
            if (i < row) {
                matrix[i - 1][j - 1] = minOf(matrix[i - 1][j - 1], matrix[i][j - 1] + 1)
            }
            if (j < col) {
                matrix[i - 1][j - 1] = minOf(matrix[i - 1][j - 1], matrix[i - 1][j] + 1)
            }
        }
    }
    return matrix
}


fun main() {
    arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0),
    ).let(::updateMatrix).map(IntArray::contentToString).forEach(::println)
    arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(1, 1, 1),
    ).let(::updateMatrix).map(IntArray::contentToString).forEach(::println)
}