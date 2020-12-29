package leetcode

/*
如果数组是单调递增或单调递减的，那么它是单调的。
如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
当给定的数组 A 是单调数组时返回 true，否则返回 false。

示例 1：
输入：[1,2,2,3]
输出：true

示例 2：
输入：[6,5,4,4]
输出：true

示例 3：
输入：[1,3,2]
输出：false

示例 4：
输入：[1,2,4,5]
输出：true

示例 5：
输入：[1,1,1]
输出：true
 
提示：
1 <= A.length <= 50000
-100000 <= A[i] <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotonic-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isMonotonic1(A: IntArray): Boolean {
    if (A.size <= 2) return true
    var index = 1
    while (index < A.size && A[index] == A[index - 1]) {
        index++
    }
    if (index == A.size) return true
    val flag = A[index] > A[index - 1]
    for (i in index until A.lastIndex) {
        if (flag && (A[i + 1] < A[i])) {
            return false
        }
        if (!flag && (A[i + 1] > A[i])) {
            return false
        }
    }
    return true
}

private fun isMonotonic(A: IntArray): Boolean {
    var increase = 0
    for (i in 1 until A.size) {
        if (increase > 0 && A[i] < A[i - 1]) return false
        if (increase < 0 && A[i] > A[i - 1]) return false
        if (increase == 0) increase = A[i] - A[i - 1]
    }
    return true
}

fun main() {
    println(isMonotonic(intArrayOf(1, 2, 2, 3)))
    println(isMonotonic(intArrayOf(6, 5, 4, 4)))
    println(isMonotonic(intArrayOf(1, 3, 2)))
    println(isMonotonic(intArrayOf(1, 2, 4, 5)))
    println(isMonotonic(intArrayOf(1, 1, 1)))
    println(isMonotonic(intArrayOf(5, 3, 2, 4, 1)))
}