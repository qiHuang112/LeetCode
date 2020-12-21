package leetcode

/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:
输入: 2.00000, 10
输出: 1024.00000

示例 2:
输入: 2.10000, 3
输出: 9.26100

示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

说明:
-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/powx-n
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * StackOverflow
 */
private fun myPow1(x: Double, n: Int): Double {
    return when {
        n == 0 -> 1.0
        n == 1 -> x
        n > 1 -> myPow(x, n - 1) * x
        else -> 1 / myPow(x, -n)
    }
}

private fun myPow(x: Double, n: Int): Double {
    if (x == 1.0) return x
    if (n == Int.MIN_VALUE) return 1 / myPow(x, Int.MAX_VALUE) / x
    if (n < 0) return 1 / myPow(x, -n)
    var temp = n
    var cur = x
    var res = 1.0
    while (temp != 0) {
        if (temp % 2 != 0) {
            res *= cur
        }
        cur *= cur
        temp /= 2
    }
    return res
}

fun main() {
//    println(myPow(2.00000, 10))
//    println(myPow(2.10000, 3))
//    println(myPow(2.00000, -2))
}
/*
2^10 = 2^8*2^2
 */