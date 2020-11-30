package leetcode

import kotlin.math.pow
import kotlin.math.sqrt

/*
求出大于或等于 N 的最小回文素数。

回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。

例如，2，3，5，7，11 以及 13 是素数。

回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。

例如，12321 是回文数。

示例 1：

输入：6
输出：7
示例 2：

输入：8
输出：11
示例 3：

输入：13
输出：101

分析回文数序列：
1
2
3
4
5
6
7
8
9
11
22
33
44
55
66
77
88
99
101
111
121
131
141
151
161
171
181
191
202
212
222
232
242

 */
private fun primePalindrome(N: Int): Int {
    // 拿到下一个回文数
    val isOdd = N.length % 2 != 0
    val index = N / 10.0.pow(N.length / 2).toInt()
    var res = getPalindrome(index, isOdd)
    while (!isPrime(res) || res < N) {
        res = nextPalindrome(res)
    }
    return res
}

private fun Int.reverse(): Int {
    var temp = this
    var res = 0
    while (temp != 0) {
        res *= 10
        res += temp % 10
        temp /= 10
    }
    return res
}

/**
 * 需要保证输入的n是回文数
 * 大于n的下一个回文数
 */
private fun nextPalindrome(n: Int): Int {
    val cur = n / (10.0.pow(n.length / 2)).toInt()
    val next = cur + 1
    val isLastOdd = n.length % 2 != 0
    val isOdd: Boolean
    val index: Int

    if (next.length > cur.length) {
        // 奇偶交替
        isOdd = !isLastOdd
        index = if (isLastOdd) next / 10 else next
    } else {
        // 奇偶保持
        isOdd = isLastOdd
        index = next
    }

    return getPalindrome(index, isOdd)
}

/**
 * 根据index以及 长度的奇偶 唯一确定一个回文数
 */
fun getPalindrome(index: Int, isOdd: Boolean): Int {
    val temp1 = if (isOdd) index.length - 1 else index.length
    val temp2 = if (isOdd) index / 10 else index
    return index * 10.0.pow(temp1).toInt() + (temp2).reverse()
}

/**
 * 正数的长度
 */
private val Int.length: Int
    get() {
        var len = 0
        var temp = this
        while (temp != 0) {
            temp /= 10
            len++
        }
        return len
    }

private fun isPrime(n: Int): Boolean {
    if (n == 1) return false
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

fun main() {
    println(primePalindrome(13))
}