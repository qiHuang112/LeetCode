package leetcode

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 动态规划
 * 设dp[i]是以index为i结尾的最大连续子数组和，那么有
 * dp[i] = maxOf(0, dp[i - 1]) + nums[i] (i 从 1 ~ nums.lastIndex)
 *
 * 进一步优化，由于每次使用都只会用到上一个dp[i]所以空间复杂度可以进一步从 o(n) 优化到o(1)
 */
private fun maxSubArray2(nums: IntArray): Int {
    var cur = nums[0]
    var res = cur
    for (i in 1 until nums.size) {
        cur = maxOf(0, cur) + nums[i]
        res = maxOf(res, cur)
    }
    return res
}


/**
 * 分治法
 * 将nums分成两半，分别计算靠左的最大子数组和，靠右的最大子数组和，区间内的最大子数组合，整个数组和
 */
private fun maxSubArray(nums: IntArray): Int {
    class Status(var lSum: Int, var rSum: Int, var mSum: Int, var sum: Int)

    fun getStatus(l: Int, r: Int): Status {
        if (l == r) return Status(nums[l], nums[l], nums[l], nums[l])
        val m = (l + r) / 2
        val lStatus = getStatus(l, m)
        val rStatus = getStatus(m + 1, r)
        return Status(
            maxOf(lStatus.lSum, lStatus.sum + rStatus.lSum),
            maxOf(rStatus.rSum, rStatus.sum + lStatus.rSum),
            maxOf(lStatus.mSum, rStatus.mSum, lStatus.rSum + rStatus.lSum),
            lStatus.sum + rStatus.sum
        )
    }
    return getStatus(0, nums.lastIndex).mSum
}

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}