package leetcode

/*
给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

示例 1：
输入：n = 13
输出：6

示例 2：
输入：n = 0
输出：0

提示：
0 <= n <= 2 * 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-digit-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力 -- 必然超时
 */
private fun countDigitOne1(n: Int): Int {
    return (1..n).fold(0) { acc, i -> acc + count1(i) }
}

private fun count1(n: Int): Int {
    var res = 0
    var temp = n
    while (temp != 0) {
        if (temp % 10 == 1) {
            res++
        }
        temp /= 10
    }
    return res
}

/**
 * 通解： k可以指定为任意其他数
 */
private fun countDigitOne2(n: Int): Int {
    val k = 1L
    var base = 1L
    var count = 0L
    while (n / base != 0L) {
        val cur = (n / base) % 10
        val high = n / (base * 10)
        val low = n - n / base * base
        when {
            cur > k -> count += (high + 1) * base
            cur == k -> count += high * base + low + 1
            cur < k -> count += high * base
        }
        base *= 10
    }
    return count.toInt()
}

private fun countDigitOne(n: Int): Int {
    var num = n
    var i = 1
    var res = 0
    while (num != 0) {
        when {
            num % 10 < 1 -> res += (num / 10) * i
            num % 10 == 1 -> res += (num / 10) * i + (n % i) + 1
            num % 10 > 1 -> res += (num / 10 + 1) * i
        }
        num /= 10
        i *= 10
    }
    return res
}

fun main() {
    println(countDigitOne(1410065408))

}
/*
0~9
10~19
20~29
30~39
40~49
50~59
60~69
70~79
80~89
90~99
0~99
0~999
0~1230
0~999
1000~1231
0~231 + 231
0~199
200~231
0~31
0~29

 */