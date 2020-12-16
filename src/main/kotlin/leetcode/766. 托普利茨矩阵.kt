package leetcode

/*
如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。

示例 1:
输入:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
输出: True
解释:
在上述矩阵中, 其对角线为:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
各条对角线上的所有元素均相同, 因此答案是True。

示例 2:
输入:
matrix = [
  [1,2],
  [2,2]
]
输出: False
解释:
对角线"[1, 2]"上的元素不同。
说明:

matrix 是一个包含整数的二维数组。
matrix 的行数和列数均在 [1, 20]范围内。
matrix[i][j] 包含的整数在 [0, 99]范围内。

进阶:
如果矩阵存储在磁盘上，并且磁盘内存是有限的，因此一次最多只能将一行矩阵加载到内存中，该怎么办？
如果矩阵太大以至于只能一次将部分行加载到内存中，该怎么办？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/toeplitz-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * o(m+n)
 */
private fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
    // 列 ： matrix[0][0] ~ matrix[i][0]
    for (i in matrix.indices) {
        var (x, y) = i to 0
        while (x in matrix.indices && y in matrix[x].indices) {
            if (matrix[x++][y++] != matrix[i][0]) {
                return false
            }
        }
    }
    // 行 ： matrix[0][0] ~ matrix[0][i]
    for (i in matrix[0].indices) {
        var (x, y) = 0 to i
        while (x in matrix.indices && y in matrix[x].indices) {
            if (matrix[x++][y++] != matrix[0][i]) {
                return false
            }
        }
    }
    return true
}

fun main() {
    println(
        isToeplitzMatrix(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 1, 2, 3),
                intArrayOf(9, 5, 1, 2),
            )
        )
    )
    println(
        isToeplitzMatrix(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 2),
            )
        )
    )
}