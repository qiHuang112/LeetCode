package leetcode

/*
和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。

示例 1:
输入: [1,3,2,2,5,2,3,7]
输出: 5
原因: 最长的和谐数组是：[3,2,2,2,3].
说明: 输入的数组长度最大不超过20,000.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 排序+查找
 */
private fun findLHS1(nums: IntArray): Int {
    nums.sort()
    var res = 0
    for (i in 0 until nums.lastIndex) {
        if (nums[i] == nums[i + 1] - 1) {
            res = maxOf(res, getRes(nums, i, i + 1))
        }
    }
    return res
}

private fun getRes(nums: IntArray, start: Int, end: Int): Int {
    var (left, right) = start to end
    while (left >= 0 && nums[left] == nums[start]) {
        left--
    }
    while (right < nums.size && nums[right] == nums[end]) {
        right++
    }
    return right - left - 1
}

/**
 * 哈希表
 */
private fun findLHS(nums: IntArray): Int {
    // 记录nums每个元素出现的次数
    val map = nums.fold(hashMapOf<Int, Int>()) { acc, i ->
        acc.also { it[i] = it.getOrDefault(i, 0) + 1 }
    }
    var res = 0
    for (key in map.keys) {
        map[key + 1]?.let { res = maxOf(res, it + map[key]!!) }
    }
    return res
}

fun main() {
    println(findLHS(intArrayOf(1, 2, 2, 2)))
    println(findLHS(intArrayOf(1, 3, 2, 2, 5, 2, 3, 7)))
    println(findLHS(intArrayOf(1, 7)))
    println(findLHS(intArrayOf(1, 2, 7)))
}