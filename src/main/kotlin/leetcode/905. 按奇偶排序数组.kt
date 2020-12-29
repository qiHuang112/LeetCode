package leetcode

/*
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
你可以返回满足此条件的任何数组作为答案。

示例：
输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。

提示：
1 <= A.length <= 5000
0 <= A[i] <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
private fun sortArrayByParity1(A: IntArray): IntArray {
    var left = 0
    var right = A.lastIndex
    while (left < right) {
        while (left < right && A[left] % 2 == 0) {
            left++
        }
        while (left < right && A[right] % 2 != 0) {
            right--
        }
        val temp = A[left]
        A[left] = A[right]
        A[right] = temp
    }
    return A
}

/**
 * 时间复杂度 o(n)
 * 空间复杂度 o(n)
 */
private fun sortArrayByParity(A: IntArray): IntArray {
    val res = IntArray(A.size)
    var left = 0
    var right = A.lastIndex
    for (n in A) {
        if (n % 2 == 0) {
            res[left++] = n
        } else {
            res[right--] = n
        }
    }
    return res
}

fun main() {
    println(intArrayOf(3, 1, 2, 4).let(::sortArrayByParity).let(IntArray::contentToString))
    println(intArrayOf(3, 1, 2, 5, 4).let(::sortArrayByParity).let(IntArray::contentToString))
    println(intArrayOf(3, 1, 6, 7, 2, 5, 4).let(::sortArrayByParity).let(IntArray::contentToString))
    println(intArrayOf(3).let(::sortArrayByParity).let(IntArray::contentToString))
    println(intArrayOf(3, 1).let(::sortArrayByParity).let(IntArray::contentToString))
}