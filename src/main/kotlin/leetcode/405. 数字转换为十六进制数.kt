package leetcode

import java.lang.StringBuilder

/*
给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
注意:

十六进制中所有字母(a-f)都必须是小写。
十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
给定的数确保在32位有符号整数范围内。
不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。

示例 1：
输入:
26
输出:
"1a"

示例 2：
输入:
-1
输出:
"ffffffff"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun toHex(num: Int): String {
    val map = "0123456789abcdef".toCharArray()
    val res = StringBuilder()
    var temp = num
    while (temp != 0) {
        res.append(map[temp.and(0xf)])
        temp = temp.ushr(4)
    }
    if (res.isEmpty()) {
        res.append(0)
    }
    return res.reverse().toString()
}

fun main() {
    println(toHex(26))
    println(toHex(-1))
}