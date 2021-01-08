package leetcode

import java.util.*

/*
给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
如果可以，请返回 True；否则，返回 False。

注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/

示例 1：
输入：nums = [1,2,3,3,4,4,5,6], k = 4
输出：true
解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。

示例 2：
输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
输出：true
解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。

示例 3：
输入：nums = [3,3,2,2,1,1], k = 3
输出：true

示例 4：
输入：nums = [1,2,3,4], k = 3
输出：false
解释：数组不能分成几个大小为 3 的子数组。
 
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * TreeMap
 */
private fun isPossibleDivide(nums: IntArray, k: Int): Boolean {
    val map = TreeMap<Int, Int>()
    for (i in nums) {
        map[i] = (map[i] ?: 0) + 1
    }
    val it = map.keys.iterator()
    while (it.hasNext()) {
        val next = it.next()
        if (map[next] == 0) continue
        for (i in 1 until k) {
            if (map[i + next] == null || map[i + next]!! < map[next]!!) {
                return false
            }
            map[i + next] = map[i + next]!! - map[next]!!
        }
        map[next] = 0
    }
    return true
}

fun main() {
    println(isPossibleDivide(intArrayOf(1, 2, 3, 3, 4, 4, 5, 6), k = 4))
    println(isPossibleDivide(intArrayOf(3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11), k = 3))
    println(isPossibleDivide(intArrayOf(3, 3, 2, 2, 1, 1), k = 3))
    println(isPossibleDivide(intArrayOf(1, 2, 3, 4), k = 3))
}