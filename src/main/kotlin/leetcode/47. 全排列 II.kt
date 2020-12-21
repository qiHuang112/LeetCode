package leetcode

import java.util.*

/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 方法1：用hash来记录已经用过的数
 */
private fun permuteUnique1(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val map = nums.fold(mutableMapOf<Int, Int>()) { acc, i ->
        acc[i] = (acc[i] ?: 0) + 1
        acc
    }
    dfs(res, nums, LinkedList(), map)
    return res
}

private fun dfs(res: MutableList<List<Int>>, nums: IntArray, temp: LinkedList<Int>, map: MutableMap<Int, Int>) {
    if (temp.size == nums.size) {
        res.add(temp.toList())
        return
    }
    for (key in map.keys) {
        if (map[key]!! > 0) {
            temp.add(key)
            map[key] = map[key]!! - 1
            dfs(res, nums, temp, map)
            temp.removeLast()
            map[key] = map[key]!! + 1
        }
    }
}

/**
 * 方法2：先排序，然后用Boolean数组记录用过的数
 */
private fun permuteUnique(nums: IntArray): List<List<Int>> {
    nums.sort()
    val map = BooleanArray(nums.size)
    val temp = LinkedList<Int>()
    val res = mutableListOf<List<Int>>()
    fun dfs(index: Int) {
        if (index == nums.size) {
            res.add(temp.toList())
            return
        }
        for (i in nums.indices) {
            if (!map[i] && (i <= 0 || nums[i] != nums[i - 1] || map[i - 1])) {
                temp.addLast(nums[i]).also { map[i] = true }
                dfs(index + 1)
                temp.removeLast().also { map[i] = false }
            }
        }
    }
    dfs(0)
    return res
}

fun main() {
    println(permuteUnique(intArrayOf(1, 2, 1)))
    println(permuteUnique(intArrayOf(1, 2, 3)))
}