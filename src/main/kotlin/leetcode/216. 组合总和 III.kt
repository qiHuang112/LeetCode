package leetcode

import java.util.*

/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：
所有数字都是正整数。
解集不能包含重复的组合。 

示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]

示例 2:
输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val temp = LinkedList<Int>()
    var sum = 0
    fun dfs(index: Int) {
        if (sum == n) {
            if (temp.size == k) {
                res.add(temp.toList())
            }
            return
        }
        if (index == 10 || temp.size > k || sum > n) return
        dfs(index + 1)
        temp.add(index)
        sum += index
        dfs(index + 1)
        temp.removeLast()
        sum -= index
    }
    dfs(1)
    return res
}

fun main() {
    println(combinationSum3(3, 7))
    println(combinationSum3(3, 9))
    println(combinationSum3(9, 45))
}