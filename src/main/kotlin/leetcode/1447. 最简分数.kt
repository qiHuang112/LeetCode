package leetcode

/*

给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。

示例 1：

输入：n = 2
输出：["1/2"]
解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
示例 2：

输入：n = 3
输出：["1/2","1/3","2/3"]
示例 3：

输入：n = 4
输出：["1/2","1/3","1/4","2/3","3/4"]
解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
示例 4：

输入：n = 1
输出：[]
 */
private fun simplifiedFractions(n: Int): List<String> {

    val res = mutableListOf<String>()
    for (i in 2..n) {
        for (j in 1..i) {
            if (isCoPrime(i, j)) {
                res.add("$j/$i")
            }
        }
    }
    return res
}

/**
 * 是否互质
 */
private fun isCoPrime(i: Int, j: Int): Boolean {
    return maxCommonDivisor(i, j) == 1
}

/**
 * 求最大公约数
 */
private tailrec fun maxCommonDivisor(i: Int, j: Int): Int {
    if (j % i == 0) {
        return i
    }
    return maxCommonDivisor(j % i, i)
}

fun main() {
    println(simplifiedFractions(4))
    println(simplifiedFractions(2))
    println(simplifiedFractions(3))
    println(simplifiedFractions(1))
    println(simplifiedFractions(5))
}