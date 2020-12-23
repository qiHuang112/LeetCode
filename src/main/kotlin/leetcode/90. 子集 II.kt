package leetcode

import java.util.*

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
说明：解集不能包含重复的子集。

示例:
输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = mutableListOf<List<Int>>()
    dfs(nums, res, 0, LinkedList())
    return res
}

private fun dfs(nums: IntArray, res: MutableList<List<Int>>, index: Int, temp: LinkedList<Int>) {
    if (index == nums.size) {
        res.add(temp.toList())
        return
    }
    var len = 1
    while (index + len < nums.size && nums[index + len] == nums[index]) {
        len++
    }
    for (i in 0..len) {
        repeat(i) {
            temp.addLast(nums[index])
        }
        dfs(nums, res, index + len, temp)
        repeat(i) {
            temp.removeLast()
        }
    }
}

fun main() {
    println(subsetsWithDup(intArrayOf(1, 2, 2)))
}