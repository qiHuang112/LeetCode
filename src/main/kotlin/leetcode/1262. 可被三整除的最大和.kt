package leetcode

/*
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。

示例 1：
输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。

示例 2：
输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。

示例 3：
输入：nums = [1,2,3,4,4]
输出：12
解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。

提示：
1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-sum-divisible-by-three
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * dp
 * 思路：状态机扭转
 */
private fun maxSumDivThree(nums: IntArray): Int {
    val dp0 = IntArray(nums.size + 1)
    val dp1 = IntArray(nums.size + 1)
    val dp2 = IntArray(nums.size + 1)
    for (i in 1..nums.size) {
        when (nums[i - 1] % 3) {
            0 -> {
                dp0[i] = maxOf(if (dp0[i - 1] == 0) nums[i - 1] else dp0[i - 1] + nums[i - 1], dp0[i - 1])
                dp1[i] = maxOf(if (dp1[i - 1] == 0) 0 else dp1[i - 1] + nums[i - 1], dp1[i - 1])
                dp2[i] = maxOf(if (dp2[i - 1] == 0) 0 else dp2[i - 1] + nums[i - 1], dp2[i - 1])
            }
            1 -> {
                dp0[i] = maxOf(if (dp2[i - 1] == 0) 0 else dp2[i - 1] + nums[i - 1], dp0[i - 1])
                dp1[i] = maxOf(if (dp0[i - 1] == 0) nums[i - 1] else dp0[i - 1] + nums[i - 1], dp1[i - 1])
                dp2[i] = maxOf(if (dp1[i - 1] == 0) 0 else dp1[i - 1] + nums[i - 1], dp2[i - 1])
            }
            2 -> {
                dp0[i] = maxOf(if (dp1[i - 1] == 0) 0 else dp1[i - 1] + nums[i - 1], dp0[i - 1])
                dp1[i] = maxOf(if (dp2[i - 1] == 0) 0 else dp2[i - 1] + nums[i - 1], dp1[i - 1])
                dp2[i] = maxOf(if (dp0[i - 1] == 0) nums[i - 1] else dp0[i - 1] + nums[i - 1], dp2[i - 1])
            }
        }
    }
    return dp0.last()
}

fun main() {
    println(maxSumDivThree(intArrayOf(3, 6, 5, 1, 8)))
    println(maxSumDivThree(intArrayOf(4)))
    println(maxSumDivThree(intArrayOf(1, 2, 3, 4, 4)))
}
/*
  1  2  3
  0  0  0
3 0  0  3
6 0  0  9
5 0  14 9
1 10 14 15
8 22 23 18
 */