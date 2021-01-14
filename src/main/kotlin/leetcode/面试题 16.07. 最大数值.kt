package leetcode

/*
编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。

示例：
输入： a = 1, b = 2
输出： 2
 */
private fun maximum(a: Int, b: Int): Int {
    // a > b -> x = 0
    // a < b -> x = -1
    val x = (a.toLong() - b.toLong()).shr(63).toInt()
    return (1 + x) * a - b * x
}

fun main() {
    println(maximum(1, 2))
}