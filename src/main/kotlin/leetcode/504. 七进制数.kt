package leetcode

import java.lang.StringBuilder

/*
给定一个整数，将其转化为7进制，并以字符串形式输出。

示例 1:
输入: 100
输出: "202"

示例 2:
输入: -7
输出: "-10"
注意: 输入范围是 [-1e7, 1e7] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/base-7
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun convertToBase7(num: Int): String {
    if (num == 0) return "0"
    val flag = num > 0
    var temp = if (flag) num else -num
    val res = StringBuilder()
    while (temp != 0) {
        res.append(temp % 7)
        temp /= 7
    }
    if (!flag) {
        res.append('-')
    }
    return res.reverse().toString()
}

fun main() {
    println(convertToBase7(100))
    println(convertToBase7(-7))
}