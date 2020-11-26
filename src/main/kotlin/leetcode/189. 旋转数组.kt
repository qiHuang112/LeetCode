package leetcode

/**
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
 */
private fun rotate(nums: IntArray, k: Int) {
    if (nums.size <= 1) return
    // 真实旋转次数
    val n = k % nums.size
    val temp = IntArray(nums.size) { nums[(it - n + nums.size) % nums.size] }
    for (i in nums.indices) {
        nums[i] = temp[i]
    }
}

fun main() {
    val arr1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    rotate(arr1, 3)
    println(arr1.contentToString())
    val arr2 = intArrayOf(-1, -100, 3, 99)
    rotate(arr2, 2)
    println(arr2.contentToString())
}