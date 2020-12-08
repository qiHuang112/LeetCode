package leetcode

import java.lang.StringBuilder

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。

示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"

提示：
每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun addBinary(a: String, b: String): String {
    val res = StringBuilder()
    var (indexA, indexB, carry, curA, curB) = arrayOf(a.lastIndex, b.lastIndex, 0, 0, 0)
    while (indexA >= 0 || indexB >= 0) {
        curA = if (indexA >= 0) a[indexA].toInt() - '0'.toInt() else 0
        curB = if (indexB >= 0) b[indexB].toInt() - '0'.toInt() else 0
        val temp = curA + curB + carry
        res.append(temp % 2)
        carry = temp / 2
        indexA--
        indexB--
    }
    if (carry == 1) {
        res.append(1)
    }
    return res.reverse().toString()
}

fun main() {
//    println(addBinary(a = "11", b = "1"))
    println(addBinary(a = "1010", b = "1011"))
}