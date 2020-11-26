package leetcode

/**
字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

示例1:

输入：s1 = "waterbottle", s2 = "erbottlewat"
输出：True
示例2:

输入：s1 = "aa", s2 = "aba"
输出：False
 */

private fun isFlipedString(s1: String, s2: String): Boolean {
    return s1.length == s2.length && "$s1$s1".contains(s2)
}

fun main() {
    println(isFlipedString(s1 = "waterbottle", s2 = "erbottlewat"))
    println(isFlipedString(s1 = "aa", s2 = "aba"))
}