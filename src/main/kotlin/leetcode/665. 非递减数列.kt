package leetcode

/*
给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

示例 1:
输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。

示例 2:
输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 
说明：
1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * 1.找到第一个比后面数大的数
 * 2.判断如果去掉这个数，或是去掉下个数，是否能形成非递减数列
 */
private fun checkPossibility(nums: IntArray): Boolean {
    var flag = false
    for (i in 1..nums.lastIndex) {
        if (nums[i - 1] > nums[i]) {
            if (flag) {
                return false
            } else {
                flag = true
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) { // 改较大的数
                    continue
                } else { // 改较小的数
                    nums[i] = nums[i - 1]
                }
            }
        }
    }
    return true
}

fun main() {
    println(checkPossibility(intArrayOf(4, 2, 3)))
    println(checkPossibility(intArrayOf(4, 2, 1)))
    println(checkPossibility(intArrayOf(5, 7, 1, 8)))
}