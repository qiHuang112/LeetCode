package leetcode

/*
累加数是一个字符串，组成它的数字可以形成累加序列。

一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1:

输入: "112358"
输出: true
解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
示例 2:

输入: "199100199"
输出: true
解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 */
private fun isAdditiveNumber(num: String): Boolean {
    return dfs(num.toCharArray(), 0, 0, 0, 0)
}

private fun dfs(chars: CharArray, index: Int, pre: Int, k: Int, sum: Int): Boolean {
    // 递归结束条件
    if (index == chars.size) {
        return k > 2
    }
    for (i in index until chars.size) {
        // 两位以上的数不能以‘0’开头
        if (chars[index] == '0' && i != index) continue
        // 求index~i组成的数字
        val cur = (index..i).fold(0) { acc, n -> 10 * acc + chars[n].toInt() - '0'.toInt() }
        // 三个数之后，当前数不是之前所有数的总合，去掉这个分支
        if (k >= 2 && cur != sum) continue
        if (dfs(chars, i + 1, cur, k + 1, pre + cur)) return true
    }
    return false
}

fun main() {
    println(isAdditiveNumber("112358"))
    println(isAdditiveNumber("199100199"))
    println(isAdditiveNumber("101"))
}