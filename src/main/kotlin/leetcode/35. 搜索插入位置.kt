package leetcode

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2

示例 2:
输入: [1,3,5,6], 2
输出: 1

示例 3:
输入: [1,3,5,6], 7
输出: 4

示例 4:
输入: [1,3,5,6], 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun searchInsert2(nums: IntArray, target: Int, left: Int = 0, right: Int = nums.lastIndex): Int {
    return when {
        left > right -> left
        nums[left] >= target -> left
        nums[right] == target -> right
        nums[right] < target -> right + 1
        // 此时nums至少有两个元素，且target在 (nums[left], nums[right])
        else -> searchInsert2(nums, target, left + 1, right - 1)
    }
}

/**
 * 二分法
 */
private fun searchInsert(nums: IntArray, target: Int, left: Int = 0, right: Int = nums.lastIndex): Int = when {
    left > right -> left
    nums[left] >= target -> left
    nums[right] == target -> right
    nums[right] < target -> right + 1
    // 此时nums至少有两个元素，且target在 (nums[left], nums[right])
    else -> {
        val mid = (left + right) / 2
        when {
            // target在 (nums[mid], nums[right])
            nums[mid] < target -> searchInsert(nums, target, mid + 1, right - 1)
            // target在 (nums[left], nums[mid])
            nums[mid] > target -> searchInsert(nums, target, left + 1, mid - 1)
            else -> mid
        }
    }
}

fun main() {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 5))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 7))
    println(searchInsert(intArrayOf(1, 3, 5, 6), 0))
    println(searchInsert(intArrayOf(1, 3), 2))
}