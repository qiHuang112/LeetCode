package leetcode

/*
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例 1:

输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-average-subarray-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findMaxAverage(nums: IntArray, k: Int): Double {
    var max = (0 until k).map(nums::get).reduce(Int::plus)
    var cur = max
    for (i in 1..nums.size - k) {
        cur += nums[i + k - 1] - nums[i - 1]
        max = maxOf(max, cur)
    }
    return max / k.toDouble()
}

fun main() {
    println(findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    println(findMaxAverage(intArrayOf(0, 1, 1, 3, 3), 4))
}