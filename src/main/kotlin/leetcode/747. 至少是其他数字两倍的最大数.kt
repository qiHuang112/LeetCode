package leetcode

/*
在一个给定的数组nums中，总是存在一个最大元素 。
查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
如果是，则返回最大元素的索引，否则返回-1。

示例 1:
输入: nums = [3, 6, 1, 0]
输出: 1
解释: 6是最大的整数, 对于数组中的其他整数,
6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.

示例 2:
输入: nums = [1, 2, 3, 4]
输出: -1
解释: 4没有超过3的两倍大, 所以我们返回 -1.

提示:
nums 的长度范围在[1, 50].
每个 nums[i] 的整数范围在 [0, 100].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 一次遍历，求出最大值和第二大值，如果最大值 是第二大值的两倍及以上，就返回索引
 */
private fun dominantIndex(nums: IntArray): Int {
    if (nums.size == 1) return 0
    var (max1, max2) = -1 to -1
    for ((i, v) in nums.withIndex()) {
        when {
            max1 == -1 -> max1 = i
            nums[max1] <= v -> {
                max2 = max1
                max1 = i
            }
            max2 == -1 -> max2 = i
            nums[max2] <= v -> max2 = i
        }
    }
    if (max1 == -1 || max2 == -1 || nums[max1] < nums[max2] * 2) {
        return -1
    }
    return max1
}

fun main() {
    println(dominantIndex(intArrayOf(3, 6, 1, 0)))
    println(dominantIndex(intArrayOf(1, 2, 3, 4)))
    println(dominantIndex(intArrayOf(1, 2)))
    println(dominantIndex(intArrayOf(1, 1)))
}