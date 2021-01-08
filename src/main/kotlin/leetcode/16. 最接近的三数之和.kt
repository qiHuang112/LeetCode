package leetcode

import kotlin.math.abs

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

提示：
3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var res = nums[0] + nums[1] + nums[2]
    fun judge(i: Int, j: Int, k: Int) {
        val cur = nums[i] + nums[j] + nums[k]
        if ((res - target).let(Math::abs) > (cur - target).let(Math::abs)) {
            res = cur
        }
    }
    for (a in 0..nums.lastIndex - 2) {
        if (a > 0 && nums[a] == nums[a - 1]) continue
        for (b in a + 1 until nums.lastIndex) {
            if (b > a + 1 && nums[b] == nums[b - 1]) continue
            var c = b + 1
            while (c < nums.size && nums[a] + nums[b] + nums[c] < target) {
                c++
            }
            if (c < nums.size) {
                judge(a, b, c)
            }
            if (c - 1 > b) {
                judge(a, b, c - 1)
            }
        }
    }
    return res
}

fun main() {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
}