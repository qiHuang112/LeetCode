package leetcode

import java.util.*
import kotlin.collections.ArrayList

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:
输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun subsets(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    dfs(res, nums, 0, LinkedList())
    return res
}

private fun dfs(res: MutableList<List<Int>>, nums: IntArray, i: Int, temp: LinkedList<Int>) {
    if (i == nums.size) {
        res.add(ArrayList(temp))
        return
    }
    dfs(res, nums, i + 1, temp)
    temp.addLast(nums[i])
    dfs(res, nums, i + 1, temp)
    temp.removeLast()
}

fun main() {
    println(subsets(intArrayOf(1, 2, 3)))
}