package leetcode

/*
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:
每个数组中的元素不会超过 100
数组的大小不会超过 200

示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
 
示例 2:
输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * dfs超时了
 */
private fun canPartition1(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) return false
    fun dfs(index: Int, target: Int): Boolean {
        if (target == 0) {
            return true
        }
        if (target < 0 || index == nums.size) {
            return false
        }
        return dfs(index + 1, target) || dfs(index + 1, target - nums[index])
    }
    return dfs(0, sum / 2)
}

/**
 * 动态规划
 */
private fun canPartition(nums: IntArray): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) return false
    val target = sum / 2
    val dp = Array(nums.size) { BooleanArray(target + 1) }
    dp[0][0] = true
    for (i in 1..nums.lastIndex) {
        for (j in 0..target) {
            dp[i][j] = dp[i - 1][j] || (j >= nums[i] && dp[i - 1][j - nums[i]])
        }
    }
    return dp.last().last()
}

fun main() {
    println(canPartition(intArrayOf(1, 5, 11, 5)))
    println(canPartition(intArrayOf(1, 2, 3, 5)))
    println(canPartition(intArrayOf(1, 2, 5)))
}