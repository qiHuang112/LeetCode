package leetcode

/*
给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x

示例 1：
输入：n = 16
输出：true

示例 2：
输入：n = 5
输出：false

示例 3：
输入：n = 1
输出：true

进阶：
你能不使用循环或者递归来完成本题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-four
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 递归
 */
private fun isPowerOfFour1(n: Int): Boolean {
    return n > 0 && (n == 1 || ((n % 4 == 0 && isPowerOfFour(n / 4))))
}

/**
 * 在二进制中，4的幂的特点
 * 1.只有一个1
 * 2.这个1在奇数位上
 * 如 : 0b0000_0100_0000_0000_0000_0000_0000_0000
 * 0b0000_0100_0000_0000_0000_0000_0000_0000
 * 0b1010_1010_1010_1010_1010_1010_1010_1010
 */
private fun isPowerOfFour(n: Int): Boolean {
    return n > 0 && n.and(n - 1) == 0 && n.and(0b0010_1010_1010_1010_1010_1010_1010_1010) == 0
}

fun main() {
    println(isPowerOfFour(16))
    println(isPowerOfFour(5))
    println(isPowerOfFour(1))
}