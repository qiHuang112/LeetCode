package leetcode

/**
 * 动态规划
 * 设dp[i]为以i结尾的最大连续1的个数，则有
 * dp[i] = if (nums[i] == 0) 0 else dp[i - 1] + nums[i]
 */
private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var res = 0
    var cur = 0
    for (num in nums) {
        cur = if (num == 0) 0 else cur + num
        res = maxOf(res, cur)
    }
    return res
}

fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))

}