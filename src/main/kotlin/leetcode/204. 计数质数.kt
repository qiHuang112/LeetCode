package leetcode

/*
统计所有小于非负整数 n 的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0

提示：
0 <= n <= 5 * 106

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-primes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力法
 */
private fun countPrimes1(n: Int): Int {
    return (0 until n).count(::isPrime)
}

private fun isPrime(i: Int): Boolean {
    if (i < 2) return false
    var j = 2
    while (j * j <= i) {
        if (i % j == 0) {
            return false
        }
        j++
    }
    return true
}

/**
 * 埃氏筛选法
 */
private fun countPrimes(n: Int): Int {
    val arr = BooleanArray(n) { true }
    var res = 0
    for (i in 2 until n) {
        // i 是质数
        if (arr[i]) {
            res++
            // 将(i, n)所有i的倍数全标记为质数
            for (j in 2 * i until n step i) {
                arr[j] = false
            }
        }
    }
    return res
}

fun main() {
    println(countPrimes(10))
    println(countPrimes(1))
    println(countPrimes(0))
//    for (i in 0..10) {
//        println("$i is ${isPrime(i)}")
//    }
//    println(isPrime(4))
}