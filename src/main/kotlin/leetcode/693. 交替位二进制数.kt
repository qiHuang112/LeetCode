package leetcode

/**
给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。

 

示例 1：

输入：n = 5
输出：true
解释：5 的二进制表示是：101
示例 2：

输入：n = 7
输出：false
解释：7 的二进制表示是：111.
示例 3：

输入：n = 11
输出：false
解释：11 的二进制表示是：1011.
示例 4：

输入：n = 10
输出：true
解释：10 的二进制表示是：1010.
示例 5：

输入：n = 3
输出：false
 */

private fun hasAlternatingBits(n: Int): Boolean {
    val t = if ((n and 1) == 0) n shr 1 else n shl 1
    val m = t xor n
    return m and (m + 1) == 0
}

fun main() {
    println(hasAlternatingBits(5))
    println(hasAlternatingBits(7))
    println(hasAlternatingBits(11))
    println(hasAlternatingBits(10))
    println(hasAlternatingBits(0b10_1010_1010_1010_1010_1010_1010_1010))
}