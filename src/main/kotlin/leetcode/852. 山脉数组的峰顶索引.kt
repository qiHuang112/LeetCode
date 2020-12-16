package leetcode

/*
我们把符合下列属性的数组 A 称作山脉：

A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

示例 1：
输入：[0,1,0]
输出：1

示例 2：
输入：[0,2,1,0]
输出：1

提示：
3 <= A.length <= 10000
0 <= A[i] <= 10^6
A 是如上定义的山脉

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 二分法
 */
private fun peakIndexInMountainArray(arr: IntArray): Int {
    var (left, right) = 1 to arr.lastIndex - 1
    while (left <= right) {
        val mid = (left + right).ushr(1)
        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return mid
        }
        if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}

fun main() {
    println(peakIndexInMountainArray(intArrayOf(0, 1, 0)))
    println(peakIndexInMountainArray(intArrayOf(0, 2, 1, 0)))
    println(peakIndexInMountainArray(intArrayOf(0, 1, 2, 3, 4, 5, 2, 1)))
    println(peakIndexInMountainArray(intArrayOf(0, 1, 2, 3, 4, 5, 2, 1).reversedArray()))
}