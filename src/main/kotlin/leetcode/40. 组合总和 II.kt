package leetcode

import kotlin.collections.ArrayList

/**
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
[1, 7],
[1, 2, 5],
[2, 6],
[1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val res = ArrayList<ArrayList<Int>>()
    candidates.sort()
    dfs(res, ArrayList(), candidates, target, 0)
    return res
}

private fun dfs(res: ArrayList<ArrayList<Int>>, temp: ArrayList<Int>, candidates: IntArray, target: Int, i: Int) {
    if (target == 0) {
        res.add(ArrayList(temp))
        return
    }
    if (target < 0) return
    if (i == candidates.size) return
    var len = 1
    while (i + len < candidates.size && candidates[i] == candidates[i + len]) {
        len++
    }
    for (j in 0..len) {
        repeat(j) { temp.add(candidates[i]) }
        dfs(res, temp, candidates, target - j * candidates[i], i + len)
        repeat(j) { temp.removeAt(temp.lastIndex) }
    }
}

fun main() {
    println(combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8))
    println(combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5))
}