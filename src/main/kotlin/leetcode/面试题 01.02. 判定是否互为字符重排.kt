package leetcode

/**
给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

示例 1：

输入: s1 = "abc", s2 = "bca"
输出: true
示例 2：

输入: s1 = "abc", s2 = "bad"
输出: false
说明：

0 <= len(s1) <= 100
0 <= len(s2) <= 100
 */
private fun CheckPermutation(s1: String, s2: String): Boolean {
    val map1 = IntArray(128)
    val map2 = IntArray(128)
    s1.forEach {  map1[it.toInt()]++}
    s2.forEach {  map2[it.toInt()]++}
    return map1.contentEquals(map2)
}

fun main() {
    println(CheckPermutation(s1 = "abc", s2 = "bca"))
    println(CheckPermutation(s1 = "abc", s2 = "bad"))
}