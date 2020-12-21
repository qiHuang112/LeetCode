package leetcode

import java.util.*
import kotlin.collections.ArrayList

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]
 */
/**
 * 广度优先搜索
 */
private fun permute1(nums: IntArray): List<List<Int>> {
    if (nums.isEmpty()) return emptyList()
    if (nums.size == 1) return listOf(listOf(nums[0]))
    val lastRes = permute(nums.sliceArray(1 until nums.size))
    val res = ArrayList<ArrayList<Int>>()
    for (i in nums.indices) {
        lastRes.forEach {
            val tempList = ArrayList(it)
            tempList.add(i, nums[0])
            res.add(tempList)
        }
    }
    return res
}

/**
 * 深度优先搜索
 */
private fun permute(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    dfs(res, nums, LinkedList(), BooleanArray(nums.size))
    return res
}

private fun dfs(res: MutableList<List<Int>>, nums: IntArray, temp: LinkedList<Int>, used: BooleanArray) {
    if (temp.size == nums.size) {
        res.add(ArrayList(temp))
        return
    }
    for (i in used.indices) {
        if (!used[i]) {
            temp.addLast(nums[i])
            used[i] = true
            dfs(res, nums, temp, used)
            temp.removeLast()
            used[i] = false
        }
    }
}

fun main() {
    println(permute(intArrayOf(1, 2, 3, 4)))
}