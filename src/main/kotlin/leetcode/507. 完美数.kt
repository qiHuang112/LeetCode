package leetcode

/*
对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
给定一个 整数 n， 如果是完美数，返回 true，否则返回 false

示例 1：
输入：28
输出：True
解释：28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, 和 14 是 28 的所有正因子。

示例 2：
输入：num = 6
输出：true

示例 3：
输入：num = 496
输出：true

示例 4：
输入：num = 8128
输出：true

示例 5：
输入：num = 2
输出：false
 
提示：
1 <= num <= 10^8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 花里胡哨
 */
private fun checkPerfectNumber1(num: Int): Boolean {
    if (num == 1) return false
    val getDivisors = { n: Int ->
        val res = mutableListOf(1)
        var temp = 2
        while (temp <= n / temp) {
            if (num % temp == 0) {
                res.add(temp)
                if (n / temp != temp) {
                    res.add(n / temp)
                }
            }
            temp++
        }
        res
    }
    return getDivisors(num).reduce(Int::plus) == num
}

/**
 * 去掉花里胡哨
 */
private fun checkPerfectNumber(num: Int): Boolean {
    if (num == 1) return false
    var res = 1
    var temp = 2
    while (temp <= num / temp) {
        if (num % temp == 0) {
            res += temp
            if (num / temp != temp) {
                res += num / temp
            }
        }
        temp++
    }
    return res == num
}

fun main() {
    println(checkPerfectNumber(num = 6))
    println(checkPerfectNumber(num = 496))
    println(checkPerfectNumber(num = 8128))
    println(checkPerfectNumber(num = 2))
}