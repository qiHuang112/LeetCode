package leetcode

import java.util.*

/*
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
说明:

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/increasing-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 造成重复的原因：后面有n个重复的数字时，选择的情况是n+1 而不是2^n
 * 所以 除了第一个可以不选之外，后面所有相同的数都得选
 */
private fun findSubsequences(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val temp = LinkedList<Int>()
    fun dfs(index: Int) {
        if (index == nums.size) {
            if (temp.size >= 2) {
                res.add(temp.toList())
            }
            return
        }
        if (temp.isEmpty() || temp.last != nums[index]) {
            dfs(index + 1)
        }
        if (temp.isEmpty() || temp.last <= nums[index]) {
            temp.add(nums[index])
            dfs(index + 1)
            temp.removeLast()
        }
    }
    dfs(0)
    return res
}

fun main() {
    println(findSubsequences(intArrayOf(6, 7, 7, 7)))
    println(findSubsequences(intArrayOf(4, 6, 7, 7)))
    println(findSubsequences(intArrayOf(1, 3, 5, 2, 9, 7, 6)))
    println(findSubsequences(intArrayOf(1, 2, 1, 1)))
    println(findSubsequences(intArrayOf(1, 1, 1)))
}