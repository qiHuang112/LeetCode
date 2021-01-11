package leetcode

import java.lang.StringBuilder

/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"

示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"

示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 递归解法
 */
private fun decodeString1(s: String): String {
    val res = StringBuilder()
    var index = 0
    while (index < s.length) {
        if (s[index].isDigit()) {
            var start = index
            var end = start
            while (end < s.length && s[end].isDigit()) {
                end++
            }
            val count = s.slice(start until end).toInt()
            start = end + 1
            end = start
            var countLeft = 1
            var countRight = 0
            while (countLeft != countRight) {
                if (s[end] == '[') {
                    countLeft++
                } else if (s[end] == ']') {
                    countRight++
                }
                end++
            }
            index = end
            res.append(decodeString1(s.slice(start until end - 1)) * count)
        } else {
            res.append(s[index++])
        }
    }
    return res.toString()
}

private operator fun String.times(i: Int): String {
    return (1..i).joinToString("") { this }
}

private fun decodeString(s: String): String {
    var cur = 0
    fun dfs(index: Int): String {
        val res = StringBuilder()
        var i = index
        var num = 0
        while (i < s.length) {
            when {
                s[i].isDigit() -> num = num * 10 + (s[i] - '0')
                s[i] == '[' -> {
                    val result = dfs(i + 1)
                    i = cur
                    while (num > 0) {
                        num--
                        res.append(result)
                    }
                }
                s[i] == ']' -> {
                    cur = i
                    return res.toString()
                }
                else -> res.append(s[i])
            }
            i++
        }
        return res.toString()
    }
    return dfs(0)
}

fun main() {
//    println(decodeString1(s = "3[a]2[bc]"))
//    println(decodeString1(s = "3[a2[c]]"))
//    println(decodeString1(s = "2[abc]3[cd]ef"))
//    println(decodeString1(s = "abc3[cd]xyz"))
//    println(decodeString1(s = "3[3[3[a]b]c]d"))
    println(decodeString(s = "3[a]2[bc]"))
    println(decodeString(s = "3[a2[c]]"))
    println(decodeString(s = "2[abc]3[cd]ef"))
    println(decodeString(s = "abc3[cd]xyz"))
    println(decodeString(s = "3[3[3[a]b]c]d"))

}