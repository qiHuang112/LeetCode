package leetcode

import java.util.*

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:
输入: "()"
输出: true

示例 2:
输入: "()[]{}"
输出: true

示例 3:
输入: "(]"
输出: false

示例 4:
输入: "([)]"
输出: false

示例 5:
输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isValid(s: String): Boolean {
    // 长度为奇数 肯定不是
    if (s.length % 2 != 0) return false
    val map = hashMapOf(')' to '(', ']' to '[', '}' to '{')
    val stack = LinkedList<Char>()
    for (c in s) {
        when (c) {
            '(', '{', '[' -> stack.offerLast(c)
            ')', '}', ']' -> {
                if (stack.isEmpty()) {
                    return false
                }
                if (stack.peekLast() == map[c]) {
                    stack.pollLast()
                } else {
                    return false
                }
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("([)]"))
    println(isValid("{[]}"))
}