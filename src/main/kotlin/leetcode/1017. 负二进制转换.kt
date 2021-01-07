package leetcode

import java.lang.StringBuilder

/*
给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
除非字符串就是 "0"，否则返回的字符串中不能含有前导零。

示例 1：
输入：2
输出："110"
解释：(-2) ^ 2 + (-2) ^ 1 = 2

示例 2：
输入：3
输出："111"
解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3

示例 3：
输入：4
输出："100"
解释：(-2) ^ 2 = 4

提示：
0 <= N <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-to-base-2
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 迭代法
 */
private fun baseNeg21(N: Int): String {
    var temp = N
    val res = StringBuilder()
    while (temp != 1) {
        if (temp > 0) {
            res.append(temp % -2)
            temp /= -2
        } else {
            if (temp % -2 == -1) {
                temp = temp / -2 + 1
                res.append(1)
            } else {
                res.append(temp % -2)
                temp /= -2
            }
        }
    }
    res.append(1)
    return res.reverse().toString()
}

/**
 * 递归法
 */
private fun baseNeg2(N: Int): String {
    if (N == 1 || N == 0) return "$N"
    if (N > 0) return baseNeg2(N / -2) + baseNeg2(N % -2)
    return baseNeg2(N / -2 - N % -2) + "${-(N % -2)}"
}

fun main() {
    println(baseNeg2(2))
    println(baseNeg2(3))
    println(baseNeg2(4))
    println(baseNeg2(5))
    println(baseNeg2(6))
}