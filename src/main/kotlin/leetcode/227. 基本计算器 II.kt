package leetcode

import java.util.*

/*
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:
输入: "3+2*2"
输出: 7

示例 2:
输入: " 3/2 "
输出: 1

示例 3:
输入: " 3+5 / 2 "
输出: 5

说明：
你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：将*和/以及它们两边的数字看做暂时变量，
 * 第一次遍历的时候，将 x*y x/y这类数据全转化掉
 * 第二次遍历的时候按顺序+和- 就好了
 *
 * 超时了
 */
private fun calculate1(s: String): Int {
    val list = LinkedList<String>()
    var (left, right) = 0 to s.lastIndex
    while (left <= right && s[left] == ' ') {
        left++
    }
    while (left <= right && s[right] == ' ') {
        right--
    }
    // 读数字 读运算符，两种模式
    var flag = true
    // 是否出现了乘除法
    var symbol = false
    while (left <= right) {
        val start = left
        var end = start
        while (end <= right && ((flag && s[end].isDigit()) || (!flag && s[end] in "+-*/"))) {
            end++
        }
        flag = !flag
        when (val cur = s.slice(start until end)) {
            "+", "-" -> list.addLast(cur)
            "*", "/" -> {
                symbol = true
                list.addLast(cur)
            }
            else -> {
                if (symbol) {
                    symbol = false
                    when (list.removeLast()) {
                        "*" -> {
                            val value = list.removeLast().toInt() * cur.toInt()
                            list.addLast(value.toString())
                        }
                        "/" -> {
                            val value = list.removeLast().toInt() / cur.toInt()
                            list.addLast(value.toString())
                        }
                    }
                } else {
                    list.addLast(cur)
                }
            }

        }
        while (end <= right && s[end] == ' ') {
            end++
        }
        left = end
    }
    var res = list.first.toInt()
    for (i in 1..list.lastIndex step 2) {
        when (list[i]) {
            "+" -> res += list[i + 1].toInt()
            "-" -> res -= list[i + 1].toInt()
        }
    }
    return res
}

private fun calculate(s: String): Int {
    val stack = LinkedList<Int>()
    var num = 0
    var operator = '+'
    for (c in "$s+0") {
        if (c == ' ') continue
        if (c.isDigit()) {
            num = 10 * num + (c - '0')
        } else {
            when (operator) {
                '+' -> stack.push(num)
                '-' -> stack.push(-num)
                '*' -> stack.push(stack.pop() * num)
                '/' -> stack.push(stack.pop() / num)
            }
            operator = c
            num = 0
        }
    }
    return stack.sum()
}

fun main() {
    println(calculate("3+2*2"))
    println(calculate(" 3/2 "))
    println(calculate(" 3+5 / 2 "))
    println(calculate("1-1+1"))
    println(calculate("0-1"))
}