package leetcode

/*
不使用运算符 + 和 - ​，计算两整数​a 、b 之和。

示例 1:
输入: a = 1, b = 2
输出: 3

示例 2:
输入: a = -2, b = 3
输出: 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 *  0100
 * 10010
 * 不允许使用加号，可以用异或来代替加法，但是异或不会进位
 * 进位可以用两个数的与并左移一位来表示，则有
 * a + b = a ^ b + ((a & b) << 1)
 * 1001 + 1101
 * = 1001 ^ 1101 + ((1001 & 1101) << 1)
 * = 0100 + 10010 = 10110
 * = 0100 ^ 10010 + ((0100 & 10010) << 1)
 * = 10110 + 0
 */
private fun getSum(a: Int, b: Int): Int {
    if (a == 0) return b
    return getSum((a and b) shl 1, a xor b)
}

fun main() {
    println(getSum(1, 2))
    println(getSum(-2, 3))
    println(getSum(0b1001, 0b1101))
}