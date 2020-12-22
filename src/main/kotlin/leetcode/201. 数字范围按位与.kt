package leetcode

/*
给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。

示例 1: 
输入: [5,7]
输出: 4

示例 2:
输入: [0,1]
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1. 如果m最高位1的位置和n的最高位1的位置不等，则结果一定是0
 * 2. 最高位都是0b1000，则，结果为 0b1000+rangeBitwiseAnd(m-0b1000,n-0b1000)
 */
private fun rangeBitwiseAnd1(m: Int, n: Int): Int {
    if (m == n) return m
    val highestOneBit = Integer.highestOneBit(n)
    if (Integer.highestOneBit(m) != highestOneBit) return 0
    return highestOneBit + rangeBitwiseAnd1(m - highestOneBit, n - highestOneBit)
}

/**
 * 给定两个整数，我们要找到它们对应的二进制字符串的公共前缀。
 */
private fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var (a, b) = m to n
    while (a < b) {
        b = b.and(b - 1)
    }
    return b
}

fun main() {
    println(rangeBitwiseAnd(5, 7))
    println(rangeBitwiseAnd(0, 1))
    println(rangeBitwiseAnd(0b11110101, 0b11111101).let(Integer::toBinaryString))
}
