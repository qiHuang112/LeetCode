package leetcode

/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:
输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun generateMatrix1(n: Int): Array<IntArray> {
    val res = Array(n) { IntArray(n) }
    var direction = 0
    var (i, j, k) = arrayOf(0, 0, 1)
    while (k <= n * n) {
        res[i][j] = k++
        when (direction) {
            0 -> {
                if (j == n - 1 || res[i][j + 1] != 0) {
                    direction = 1
                    i++
                } else {
                    j++
                }
            }
            1 -> {
                if (i == n - 1 || res[i + 1][j] != 0) {
                    direction = 2
                    j--
                } else {
                    i++
                }
            }
            2 -> {
                if (j == 0 || res[i][j - 1] != 0) {
                    direction = 3
                    i--
                } else {
                    j--
                }
            }
            3 -> {
                if (i == 0 || res[i - 1][j] != 0) {
                    direction = 0
                    j++
                } else {
                    i--
                }
            }
        }
    }
    return res
}

private fun generateMatrix(n: Int): Array<IntArray> {
    val res = Array(n) { IntArray(n) }
    var direction = 0
    val arr = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))
    var (i, j, k) = arrayOf(0, 0, 1)
    while (k <= n * n) {
        res[i][j] = k++
        if (i + arr[direction][0] !in 0 until n
            || j + arr[direction][1] !in 0 until n
            || res[i + arr[direction][0]][j + arr[direction][1]] != 0
        ) {
            direction = (direction + 1) % 4
        }
        i += arr[direction][0]
        j += arr[direction][1]
    }
    return res
}

fun main() {
    generateMatrix(3).map(IntArray::contentToString).forEach(::println)
    generateMatrix(4).map(IntArray::contentToString).forEach(::println)
}