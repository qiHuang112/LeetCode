package leetcode

import java.lang.StringBuilder

/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty() || strs[0].isEmpty()) return ""
    val res = StringBuilder()
    var flag = true
    for ((i, c) in strs[0].withIndex()) {
        for (str in strs) {
            flag = judge(i, c, str)
            if (!flag) return res.toString()
        }
        res.append(c)
    }
    return res.toString()
}

private fun judge(i: Int, c: Char, str: String): Boolean {
    if (i !in str.indices) return false
    return str[i] == c
}

fun main() {
    println(longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}