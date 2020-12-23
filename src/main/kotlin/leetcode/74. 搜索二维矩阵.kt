package leetcode

/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
输出：true

示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
输出：false

示例 3：
输入：matrix = [], target = 0
输出：false

提示：
m == matrix.length
n == matrix[i].length
0 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var x = matrix.lastIndex
    var y = 0
    while (x >= 0 && y < matrix[0].size && matrix[x][y] != target) {
        if (matrix[x][y] > target) {
            x--
        } else {
            y++
        }
    }
    return x >= 0 && y < matrix[0].size
}

fun main() {
    for (i in 0..50) {
        searchMatrix(
            arrayOf(
                intArrayOf(1, 3, 5, 7),
                intArrayOf(10, 11, 16, 20),
                intArrayOf(23, 30, 34, 50),
            ), i
        ).let {
            if (it) {
                println(i)
            }
        }
    }
}