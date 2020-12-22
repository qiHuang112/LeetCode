package leetcode

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]

提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 是一个非递减数组
-10^9 <= target <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * 1.二分法找到某一个target的index
 * 2.二分法找到index最左的leftIndex
 * 3.二分法找到index最右的rightIndex
 * 4.return intArrayOf(leftIndex, rightIndex)
 */
private fun searchRange(nums: IntArray, target: Int): IntArray {
    val index = binarySearch(nums, target)
    if (index == -1) {
        return intArrayOf(-1, -1)
    }
    return intArrayOf(findLeft(nums, target, 0, index), findRight(nums, target, index, nums.lastIndex))
}

private fun findLeft(nums: IntArray, target: Int, start: Int, end: Int): Int {
    if (nums[start] == target) return start
    val mid = (start + end).ushr(1)
    if (nums[mid] == target) {
        return if (mid == start) mid else findLeft(nums, target, start, mid)
    }
    return findLeft(nums, target, mid + 1, end)
}

private fun findRight(nums: IntArray, target: Int, start: Int, end: Int): Int {
    if (nums[end] == target) return end
    val mid = (start + end).ushr(1)
    if (nums[mid] == target) {
        return if (mid == start) start else findRight(nums, target, mid, end)
    }
    return findRight(nums, target, start, mid - 1)
}

private fun binarySearch(nums: IntArray, target: Int, start: Int = 0, end: Int = nums.lastIndex): Int {
    if (start > end || target !in nums[start]..nums[end]) {
        return -1
    }
    val mid = (start + end).ushr(1)
    if (target == nums[mid]) {
        return mid
    }
    if (target > nums[mid]) {
        return binarySearch(nums, target, mid + 1, end)
    }
    return binarySearch(nums, target, start, mid - 1)
}


fun main() {
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString())
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentToString())
    println(searchRange(intArrayOf(5, 7, 7, 7, 8, 8, 10), 8).contentToString())
    println(searchRange(intArrayOf(1, 2, 3, 3, 3, 3, 4, 5, 9), 3).contentToString())
    println(searchRange(intArrayOf(), 0).contentToString())
}