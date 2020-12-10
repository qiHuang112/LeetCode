package leetcode

import java.lang.StringBuilder

/*
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

提示：
num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun addStrings(num1: String, num2: String): String {
    val arr1 = num1.toCharArray()
    val arr2 = num2.toCharArray()
    var (index1, index2) = arr1.lastIndex to arr2.lastIndex
    var carry = 0
    val res = StringBuilder()
    while (index1 >= 0 || index2 >= 0) {
        val temp1 = if (index1 >= 0) arr1[index1--] - '0' else 0
        val temp2 = if (index2 >= 0) arr2[index2--] - '0' else 0
        val cur = temp1 + temp2 + carry
        res.insert(0, cur % 10)
        carry = cur / 10
    }
    if (carry == 1) {
        res.insert(0, 1)
    }
    return res.toString()
}

fun main() {
    println(addStrings("111", "111"))
    println(addStrings("811", "991"))
}