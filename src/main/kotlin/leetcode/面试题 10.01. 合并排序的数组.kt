package leetcode

/*
给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
初始化 A 和 B 的元素数量分别为 m 和 n。

示例:
输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
说明:

A.length == n + m
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sorted-merge-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun merge(A: IntArray, m: Int, B: IntArray, n: Int): Unit {
    var (i1, i2) = m - 1 to n - 1
    while (i1 >= 0 || i2 >= 0) {
        when {
            i1 < 0 -> A[i1 + i2 + 1] = B[i2--]
            i2 < 0 -> A[i1 + i2 + 1] = A[i1--]
            A[i1] < B[i2] -> A[i1 + i2 + 1] = B[i2--]
            else -> A[i1 + i2 + 1] = A[i1--]
        }
    }
}

fun main() {
    val a = intArrayOf(1, 2, 3, 0, 0, 0)
    val b = intArrayOf(2, 5, 6)
    merge(a, 3, b, 3)
    println(a.contentToString())
}