package leetcode

/*
升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1

提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
nums 肯定会在某个点上旋转
-10^4 <= target <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun search(nums: IntArray, target: Int): Int {
    return search(nums, target, 0, nums.lastIndex)
}

private fun search(nums: IntArray, target: Int, left: Int, right: Int): Int {
    if (left > right) return -1
    if (nums[left] == target) return left
    if (nums[right] == target) return right
    val mid = (left + right).ushr(1)
    if (nums[mid] == target) {
        return mid
    }
    // 递增区间
    if (nums[left] < nums[right]) {
        return binarySearch(nums, target, left, right)
    }
    // [left,mid]↗  [mid,right]继续递归
    if (nums[mid] > nums[left]) {
        if (target < nums[left] || target > nums[mid]) {
            return search(nums, target, mid + 1, right)
        }
        return binarySearch(nums, target, left, mid - 1)
    }
    // [left,mid]继续递归  [mid,right]↗
    if (target < nums[mid] || target > nums[right]) {
        return search(nums, target, left, mid - 1)
    }
    return binarySearch(nums, target, mid + 1, right)
}

private fun binarySearch(nums: IntArray, target: Int, left: Int, right: Int): Int {
    if (target == nums[left]) return left
    if (target == nums[right]) return right
    if (target < nums[left] || target > nums[right]) return -1
    val mid = (left + right).ushr(1)
    if (nums[mid] == target) return mid
    if (nums[mid] > target) return binarySearch(nums, target, left, mid - 1)
    return binarySearch(nums, target, mid + 1, right)
}

fun main() {
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 4))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 5))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 6))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 7))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 9))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 10))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 0))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 1))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 2))
    println(search(intArrayOf(4, 5, 6, 7, 9, 10, 0, 1, 2), 3))
}