package leetcode

/*
给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

示例 1:
输入: [1,1,2,3,3,4,4,8,8]
输出: 2

示例 2:
输入: [3,3,7,7,10,11,11]
输出: 10

注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 异或
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
private fun singleNonDuplicate1(nums: IntArray): Int {
    return nums.fold(0, Int::xor)
}

/**
 * 二分法
 * 每次切奇数个数，前两个数相同，后两个数相同，说明答案在此区间
 * 时间复杂度 o(log n)
 * 空间复杂度 o(1)
 */
private fun singleNonDuplicate(nums: IntArray): Int {
    return binarySearch(nums, 0, nums.lastIndex)
}

private fun binarySearch(nums: IntArray, start: Int, end: Int): Int {
    println("[$start, $end]")
    if (start == end) return nums[start]
    if (nums[start] != nums[start + 1]) return nums[start]
    if (nums[end] != nums[end - 1]) return nums[end]
    val mid = (start + end).ushr(1)
    if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
        return nums[mid]
    }
    // [start, mid] 有奇数个数
    if ((mid - start) % 2 == 0) {
        if (nums[mid] == nums[mid - 1]) {
            return binarySearch(nums, start, mid - 2)
        }
        return binarySearch(nums, mid, end)
    }
    // [start, mid] 有偶数个
    if (nums[mid] == nums[mid - 1]) {
        return binarySearch(nums, mid + 1, end)
    }
    return binarySearch(nums, start, mid - 1)
}

fun main() {
    println(singleNonDuplicate(intArrayOf(1, 1, 2, 2, 4, 4, 8, 8, 9, 9, 10, 10, 11, 11, 12, 13, 13)))
//    println(singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)))
//    println(singleNonDuplicate(intArrayOf(1)))
//    println(singleNonDuplicate(intArrayOf(1, 1, 2)))
//    println(singleNonDuplicate(intArrayOf(1, 1, 2)))
}