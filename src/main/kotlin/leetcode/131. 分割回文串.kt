package leetcode

import java.util.*

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。

示例:
输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路:两步走
 * 1.遍历所有可能的切法 2^(s.length - 1)种切法
 * 2.剪枝
 *
 * 思考：
 * 剪枝要对每个子串进行是否回文串判断，是否能用dp[i][j]空间换时间，简化复杂度
 */
private fun partition(s: String): List<List<String>> {
    if (s.length <= 1) return listOf(listOf(s))
    val dp = Array(s.length) { BooleanArray(s.length) }
    dp[0][0] = true
    fun spread(i: Int, j: Int) {
        var n = 0
        while (i - n >= 0 && j + n < s.length && s[i - n] == s[j + n]) {
            dp[i - n][j + n] = true
            n++
        }
    }
    for (i in 1..dp.lastIndex) {
        spread(i, i)
        spread(i - 1, i)
    }
    val res = mutableListOf<List<String>>()
    dfs(res, 1, LinkedList<IntRange>().apply { add(0..1) }, s, dp)
    return res
}

/**
 * 遍历方式会修改既定temp的最后一个元素，不利于剪枝
 * 需要寻找其他遍历方式
 */
private fun dfs(
    res: MutableList<List<String>>, index: Int,
    temp: LinkedList<IntRange>, s: String, dp: Array<BooleanArray>
) {
    if (index == s.length) {
        if (temp.any { !dp[it.first][it.last] }) return
        res.add(temp.map(s::slice))
        return
    }
    val last = temp.last
    // 1.与上一个粘到一起
    temp[temp.lastIndex] = last.first..index
    dfs(res, index + 1, temp, s, dp)
    temp[temp.lastIndex] = last.first until index
    // 2.不粘到一起
    temp.addLast(index..index)
    dfs(res, index + 1, temp, s, dp)
    temp.removeLast()
}


fun main() {
    println(partition("aab"))
    println(partition("aabba"))
    println(partition("aabcaddacd"))
}

/*
a

a a
aa

a a b
aa b
a ab
aab
 */