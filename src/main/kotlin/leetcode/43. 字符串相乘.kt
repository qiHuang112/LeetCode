package leetcode

import java.lang.StringBuilder

/*
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * num1的第i位和num2的第j位，乘积的结果放在res的第[i+j, i+j+1]位
 * 所以 res的长度为i+j+2 减去前导0的个数
 */
private fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"
    val res = IntArray(num1.length + num2.length)
    for (i in num1.lastIndex downTo 0) {
        val n1 = num1[i] - '0'
        for (j in num2.lastIndex downTo 0) {
            val temp = n1 * (num2[j] - '0') + res[i + j + 1]
            res[i + j + 1] = temp % 10
            res[i + j] += temp / 10
//            println(res.contentToString())
        }
    }
    return (res.indexOfFirst { it > 0 }..res.lastIndex).joinToString("") { "${res[it]}" }
}

fun main() {
    println(multiply(num1 = "2", num2 = "3"))
    println(multiply(num1 = "123", num2 = "456"))
    println(multiply(num1 = "99", num2 = "99"))
}