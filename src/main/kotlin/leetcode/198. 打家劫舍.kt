package leetcode

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：
0 <= nums.length <= 100
0 <= nums[i] <= 400

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 动态规划
 * 设dp[i] 为从-1(给nums最前面加一个0)开始偷，正好偷到i这个点的最高金额，则有
 * dp[i] = maxOf(dp[i-2], dp[i-3]) + nums[i-1]
 */
private fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    if (nums.size <= 2) return nums.reduce(::maxOf)
    val dp = IntArray(nums.size + 1).apply {
        this[0] = 0
        this[1] = nums[0]
        this[2] = nums[1]
    }
    var max = maxOf(dp[1], dp[2])
    for (i in 3..nums.size) {
        dp[i] = maxOf(dp[i - 2], dp[i - 3]) + nums[i - 1]
        max = maxOf(max, dp[i])
    }
    return max
}

fun main() {
    println(rob(intArrayOf(1, 2, 3, 1)))
    println(rob(intArrayOf(2, 7, 9, 3, 1)))
    println(rob(intArrayOf(1, 3, 1)))
}