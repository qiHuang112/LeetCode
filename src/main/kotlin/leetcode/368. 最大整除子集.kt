package leetcode

import java.util.*


/*
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
如果有多个目标子集，返回其中任何一个均可。

示例 1:
输入: [1,2,3]
输出: [1,2] (当然, [1,3] 也正确)

示例 2:
输入: [1,2,4,8]
输出: [1,2,4,8]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-divisible-subset
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1,dfs实现
 */
private fun largestDivisibleSubset1(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return emptyList()
    nums.sort()
    var res = listOf(nums[0])
    val temp = LinkedList<Int>()
    fun dfs(index: Int) {
        if (index == nums.size) {
            if (res.size < temp.size) {
                res = temp.toList()
            }
            return
        }
        if (nums.size - index + 1 < res.size - temp.size) {
            return
        }
        if (temp.isEmpty() || nums[index] % temp.last == 0) {
            temp.addLast(nums[index])
            dfs(index + 1)
            temp.removeLast()
        }
        dfs(index + 1)
    }
    dfs(0)
    return res
}

/**
 * 2.动态规划 + 回溯
 * todo
 */
private fun largestDivisibleSubset(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return emptyList()
    nums.sort()
    val dp = IntArray(nums.size) { 1 }
    for (i in 1..nums.lastIndex) {
        for (j in i - 1 downTo 0) {
            if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
                println("${nums[j]} -> ${nums[i]} ")
            }
        }
    }
    println(dp.contentToString())
    return emptyList()
}

fun main() {
    println(largestDivisibleSubset(intArrayOf(1, 2, 3)))
    println(largestDivisibleSubset(intArrayOf(1, 2, 4, 8)))
    println(largestDivisibleSubset(intArrayOf(1, 2, 3, 5, 6, 7, 8, 9)))
}