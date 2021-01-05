package leetcode

/*
给定一个 n × n 的二维矩阵表示一个图像。
将图像顺时针旋转 90 度。
说明：
你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 *  先水平翻转，然后对角翻转
 */
private fun rotate(matrix: Array<IntArray>): Unit {
    fun swap(a1: Int, b1: Int, a2: Int, b2: Int) {
        val temp = matrix[a1][b1]
        matrix[a1][b1] = matrix[a2][b2]
        matrix[a2][b2] = temp
    }

    val size = matrix.size
    // 水平翻转
    for (i in 0 until size) {
        for (j in 0..(size - 1) / 2) {
            swap(i, j, i, size - 1 - j)
        }
    }
    // 对角翻转
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (i + j < size) {
                swap(i, j, size - 1 - j, size - 1 - i)
            }
        }
    }
}

fun main() {
    arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    ).apply(::rotate).map(IntArray::contentToString).forEach(::println)
    arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16),
    ).apply(::rotate).map(IntArray::contentToString).forEach(::println)
}
/*
1 2 3
4 5 6
7 8 9

3 2 1
6 5 4
9 8 7

7 4 1
8 5 2
9 6 3




 */
