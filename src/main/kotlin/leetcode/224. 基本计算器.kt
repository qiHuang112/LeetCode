package leetcode

import java.util.*

/*
实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。

示例 1：
输入：s = "1 + 1"
输出：2

示例 2：
输入：s = " 2-1 + 2 "
输出：3

示例 3：
输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23

提示：
1 <= s.length <= 3 * 105
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 额外考虑乘除法的话
 */
private fun calculate(s: String): Int {
    val queue = LinkedList<Int>()
    var num = 0
    var index = 0
    var op = '+'
    while (index < s.length) {
        if (s[index] == ' ') {
            index++
            continue
        }
        if (s[index].isDigit()) {
            num = num * 10 + (s[index] - '0')
            index++
            continue
        }
        if (s[index] == '(') {
            val start = index + 1
            var end = start
            var left = 1
            var right = 0
            while (left != right) {
                end++
                val cur = s[++index]
                if (cur == '(') left++ else if (cur == ')') right++
            }
            num = calculate(s.substring(start, end))
            index++
            continue
        }
        when (op) {
            '+' -> queue.push(num)
            '-' -> queue.push(-num)
            '*' -> queue.push(queue.pop() * num)
            '/' -> queue.push(queue.pop() / num)
        }
        num = 0
        op = s[index]
        index++
    }
    when (op) {
        '+' -> queue.push(num)
        '-' -> queue.push(-num)
        '*' -> queue.push(queue.pop() * num)
        '/' -> queue.push(queue.pop() / num)
    }
    return queue.fold(0, Int::plus)
}

fun main() {
    println(calculate(s = "1 + 1"))
    println(calculate(s = " 2-1 + 2 "))
    println(calculate(s = "(1+(4+5+2)-3)+(6+8)"))
    println(calculate(s = "(1+(4+5*2)-3)+(6+8/3)"))
}