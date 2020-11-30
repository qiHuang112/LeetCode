package leetcode

/*
给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。

示例 1:

输入: "abab"

输出: True

解释: 可由子字符串 "ab" 重复两次构成。
示例 2:

输入: "aba"

输出: False
示例 3:

输入: "abcabcabcabc"

输出: True

解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 */
private fun repeatedSubstringPattern(s: String): Boolean {
    for (i in 1..s.length / 2) {
        if (s.length % i == 0) {
            val template = s.substring(0, i)
            if (canBuildS(template, s)) {
                return true
            }
        }
    }
    return false
}

/*
 * 是否能通过template得到s
 */
private fun canBuildS(template: String, s: String): Boolean {
    var index = 0
    while (index <= s.length - template.length) {
        if (s.substring(index, index + template.length) != template) {
            return false
        }
        index += template.length
    }
    return true
}


fun main() {
    println(repeatedSubstringPattern("abab"))
    println(repeatedSubstringPattern("aba"))
    println(repeatedSubstringPattern("abcabcabcabc"))
}