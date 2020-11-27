package leetcode

import kotlin.math.max

/**
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0
 */
private fun lengthOfLongestSubstring(s: String): Int {
    val map = IntArray(128) { -1 }
    var start = 0
    var res = 0
    for (i in s.indices) {
        if (map[s[i].toInt()] >= 0) {
            start = max(start, map[s[i].toInt()] + 1)
        }
        map[s[i].toInt()] = i
        res = max(res, i - start + 1)
    }
    return res
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(""))
    println(lengthOfLongestSubstring(" "))
    println(lengthOfLongestSubstring("aab"))
    println(lengthOfLongestSubstring("abba"))
}