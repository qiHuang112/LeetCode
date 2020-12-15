package leetcode

/*
包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
示例 1:
输入:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
输出:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
注意:

给定矩阵中的整数范围为 [0, 255]。
矩阵的长和宽的范围均为 [1, 150]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/image-smoother
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
    return Array(M.size) { i ->
        IntArray(M[i].size) { j ->
            var sum = 0
            var count = 0
            for (k in i - 1..i + 1) {
                for (n in j - 1..j + 1) {
                    if (k in M.indices && n in M[i].indices) {
                        sum += M[k][n]
                        count++
                    }
                }
            }
            sum / count
        }
    }
}

fun main() {
    imageSmoother(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 10, 1),
            intArrayOf(1, 1, 1),
        )
    ).map(IntArray::contentToString).forEach(::println)
    imageSmoother(
        arrayOf(
            intArrayOf(2, 3, 4),
            intArrayOf(5, 6, 7),
            intArrayOf(8, 9, 10),
            intArrayOf(11, 12, 13),
            intArrayOf(14, 15, 16),
        )
    ).map(IntArray::contentToString).forEach(::println)
}