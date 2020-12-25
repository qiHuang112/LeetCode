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
private fun partition1(s: String): List<List<String>> {
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
    dfs1(res, 1, LinkedList<IntRange>().apply { add(0..1) }, s, dp)
    return res
}

/**
 * 遍历方式会修改既定temp的最后一个元素，不利于剪枝
 * 需要寻找其他遍历方式
 */
private fun dfs1(
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
    dfs1(res, index + 1, temp, s, dp)
    temp[temp.lastIndex] = last.first until index
    // 2.不粘到一起
    temp.addLast(index..index)
    dfs1(res, index + 1, temp, s, dp)
    temp.removeLast()
}

/**
 * 换一种dfs的方法，避免更改temp中的最后一个元素
 * 分为两类：
 * 当前元素与后一个相连，
 * 当前元素与后一个不相连
 */
private fun partition2(s: String): List<List<String>> {
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
    dfs2(res, 0, LinkedList<IntRange>(), s, dp)
    return res
}

private fun dfs2(
    res: MutableList<List<String>>, index: Int,
    temp: LinkedList<IntRange>, s: String, dp: Array<BooleanArray>
) {
    if (index == s.length) {
        res.add(temp.map(s::slice))
        return
    }
    // 1.当前index与下一个不相连
    temp.addLast(index..index)
    dfs2(res, index + 1, temp, s, dp)
    temp.removeLast()
    // 2.当前节点与下一个相连
    for (i in index + 1..s.lastIndex) {
        if (dp[index][i]) {
            temp.addLast(index..i)
            dfs2(res, i + 1, temp, s, dp)
            temp.removeLast()
        }
    }
}

/**
 * 发现提交之后时间还是耗挺多，尝试不用dp判断回文数
 * 发现不用dp更慢了
 * 然后把题解的输进去，发现跟我差不多。。
 */
private fun partition(s: String): List<List<String>> {
    if (s.length <= 1) return listOf(listOf(s))
    val res = mutableListOf<List<String>>()
    dfs(res, 0, LinkedList<IntRange>(), s)
    return res
}

private fun dfs(res: MutableList<List<String>>, index: Int, temp: LinkedList<IntRange>, s: String) {
    if (index == s.length) {
        res.add(temp.map(s::slice))
        return
    }
    // 1.当前index与下一个不相连
    temp.addLast(index..index)
    dfs(res, index + 1, temp, s)
    temp.removeLast()
    // 2.当前节点与下一个相连
    for (i in index + 1..s.lastIndex) {
        if (isPlalindrome(s, index, i)) {
            temp.addLast(index..i)
            dfs(res, i + 1, temp, s)
            temp.removeLast()
        }
    }
}

private fun isPlalindrome(s: String, from: Int = 0, to: Int = s.lastIndex): Boolean {
    var (left, right) = from to to
    while (left < right) {
        if (s[left] == s[right]) {
            left++
            right--
        } else {
            return false
        }
    }
    return true
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