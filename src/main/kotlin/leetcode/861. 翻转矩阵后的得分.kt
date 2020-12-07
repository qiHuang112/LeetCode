package leetcode

/*
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。

示例：

输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

提示：

1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] 是 0 或 1
 */
/*
1.如果选择的是行，则要反转后值更大才反转
2.如果选择的是列，则要反转后1的个数更多才反转
3.反转是否有先后顺序 - 没有先后顺序
 */
private fun matrixScore(A: Array<IntArray>): Int {
    val sumInt = { a: Int, b: Int -> a * 2 + b }
    val sumArr = { a: Int, b: IntArray -> a + b.fold(0, sumInt) }
    var flag = true
    while (flag) {
        flag = false
        // 行
        for (arr in A) {
            if (arr[0] != 1) {
                flag = true
                for (i in arr.indices) {
                    arr[i] = 1 - arr[i]
                }
            }
        }
        // 列
        for (i in A[0].indices) {
            var count = 0
            for (j in A.indices) {
                if (A[j][i] == 1) {
                    count++
                }
            }
            if (count * 2 < A.size) {
                flag = true
                for (j in A.indices) {
                    A[j][i] = 1 - A[j][i]
                }
            }
        }
    }
    return A.fold(0, sumArr)
}

fun main() {
    println(
        matrixScore(
            arrayOf(
                intArrayOf(0, 0, 1, 1),
                intArrayOf(1, 0, 1, 0),
                intArrayOf(1, 1, 0, 0),
            )
        )
    )
}