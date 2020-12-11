package leetcode

/*
给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
返回该 最大总和 。

示例 1：
输入：nums = [1,4,3,2]
输出：4
解释：所有可能的分法（忽略元素顺序）为：
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
所以最大总和为 4

示例 2：
输入：nums = [6,2,6,5,1,2]
输出：9
解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9

提示：
1 <= n <= 10^4
nums.length == 2 * n
-10^4 <= nums[i] <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/array-partition-i
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 一顿分析 先排序，再取index为偶数的累加
 * 一样直接高阶函数一行搞定
 */
private fun arrayPairSum1(nums: IntArray): Int {
    return nums.sorted().filterIndexed { index, _ -> index % 2 == 0 }.reduce(Int::plus)
}

/**
 * 还是写个正常点的吧
 */
private fun arrayPairSum(nums: IntArray): Int {
    nums.sort()
    var res = 0
    for (i in nums.indices step 2) {
        res += nums[i]
    }
    return res
}

fun main() {
    println(arrayPairSum(intArrayOf(1, 4, 3, 2)))
    println(arrayPairSum(intArrayOf(6, 2, 6, 5, 1, 2)))
}