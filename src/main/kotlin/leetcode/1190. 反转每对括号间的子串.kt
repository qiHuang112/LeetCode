package leetcode

import java.lang.StringBuilder

/*
给出一个字符串 s（仅含有小写英文字母和括号）。
请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
注意，您的结果中 不应 包含任何括号。

示例 1：
输入：s = "(abcd)"
输出："dcba"

示例 2：
输入：s = "(u(love)i)"
输出："iloveu"

示例 3：
输入：s = "(ed(et(oc))el)"
输出："leetcode"

示例 4：
输入：s = "a(bcdefghijkl(mno)p)q"
输出："apmnolkjihgfedcbq"
 
提示：
0 <= s.length <= 2000
s 中只有小写英文字母和括号
我们确保所有括号都是成对出现的

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力递归
 */
private fun reverseParentheses1(s: String): String {
    var index = 0
    val res = StringBuilder()
    while (index < s.length) {
        while (index < s.length && s[index] != '(') {
            res.append(s[index++])
        }
        if (index++ == s.length) break
        val start = index
        var leftCount = 1
        var rightCount = 0
        while (leftCount != rightCount) {
            when (s[index++]) {
                '(' -> leftCount++
                ')' -> rightCount++
            }
        }
        res.append(reverseParentheses(s.substring(start, index - 1)).reversed())
    }
    return res.toString()
}

/**
 * 栈
 */
private fun reverseParentheses(s: String): String {
    var cur = 0
    fun dfs(index: Int): String {
        val res = StringBuilder()
        var i = index
        while (i < s.length) {
            when {
                s[i].isLetter() -> res.append(s[i])
                s[i] == '(' -> {
                    res.append(dfs(i + 1))
                    i = cur
                }
                s[i] == ')' -> {
                    cur = i
                    return res.reverse().toString()
                }
            }
            i++
        }
        return res.toString()
    }
    return dfs(0)
}

fun main() {
    println(reverseParentheses(s = "(abcd)"))
    println(reverseParentheses(s = "(u(love)i)"))
    println(reverseParentheses(s = "(ed(et(oc))el)"))
    println(reverseParentheses(s = "a(bcdefghijkl(mno)p)q"))
}