package leetcode

import java.lang.StringBuilder

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
如果小数部分为循环小数，则将循环的部分括在括号内。
如果存在多个答案，只需返回 任意一个 。
对于所有给定的输入，保证 答案字符串的长度小于 104 。

示例 1：
输入：numerator = 1, denominator = 2
输出："0.5"

示例 2：
输入：numerator = 2, denominator = 1
输出："2"

示例 3：
输入：numerator = 2, denominator = 3
输出："0.(6)"

示例 4：
输入：numerator = 4, denominator = 333
输出："0.(012)"

示例 5：
输入：numerator = 1, denominator = 5
输出："0.2"
 
提示：
-2^31 <= numerator, denominator <= 2^31 - 1
denominator != 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 这题到时不难，就是一直卡边界恶心人，有点想吐
 */
private fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) return "0"
    if (numerator < 0 && denominator < 0) {
        return getRes(-numerator.toLong(), -denominator.toLong())
    }
    if (numerator < 0 || denominator < 0) {
        return "-" + getRes(numerator.toLong().let(Math::abs), denominator.toLong().let(Math::abs))
    }
    return getRes(numerator.toLong(), denominator.toLong())
}

private fun getRes(numerator: Long, denominator: Long): String {
    val res = StringBuilder().append(numerator / denominator)
    var num = numerator % denominator
    if (num == 0L) return res.toString()
    res.append(".")
    val map = mutableMapOf<Long, Int>()
    var index = res.length
    while (true) {
        num *= 10
        val cur = num / denominator
        if (map[num] != null) {
            val startIndex = map[num]!!
            res.insert(startIndex, '(').append(')')
            break
        }
        map[num] = index++
        res.append(cur)
        num %= denominator
        if (num == 0L) return res.toString()
    }
    return res.toString()
}

fun main() {
    println(fractionToDecimal(numerator = 1, denominator = 2))
    println(fractionToDecimal(numerator = 2, denominator = 1))
    println(fractionToDecimal(numerator = 2, denominator = 3))
    println(fractionToDecimal(numerator = 4, denominator = 333))
    println(fractionToDecimal(numerator = 4, denominator = 3333))
    println(fractionToDecimal(numerator = 1, denominator = 5))
    println(fractionToDecimal(numerator = 1, denominator = 7))
    println(fractionToDecimal(numerator = 1, denominator = 6))
    println(fractionToDecimal(numerator = 2, denominator = 7))
    println(fractionToDecimal(numerator = 10, denominator = 7))
    println(fractionToDecimal(numerator = 111, denominator = 9))
    println(fractionToDecimal(numerator = -111, denominator = 9))
    println(fractionToDecimal(numerator = -1, denominator = Int.MIN_VALUE))
}