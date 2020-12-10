package leetcode

/*
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
给定一个数字 n，找出可形成完整阶梯行的总行数。
n 是一个非负整数，并且在32位有符号整型的范围内。

示例 1:
n = 5
硬币可排列成以下几行:
¤
¤ ¤
¤ ¤
因为第三行不完整，所以返回2.

示例 2:
n = 8
硬币可排列成以下几行:
¤
¤ ¤
¤ ¤ ¤
¤ ¤
因为第四行不完整，所以返回3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/arranging-coins
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 0 -> 0
 * 1~2 -> 1
 * 3~5 -> 2
 * 6~9 -> 3
 * i(i+1)/2 ~ (i+2)(i+1)/2 - 1-> i
 */

/**
 * 暴力法 -- 超时，且有Int溢出风险
 */
private fun arrangeCoins1(n: Int): Int {
    var i = 0
    while (n > (i + 2) * (i + 1) / 2 - 1) {
        i++
    }
    return i
}

/**
 * 二分法
 */
private fun arrangeCoins(n: Int): Int {
    var (left, right) = 0 to n
    while (left < right) {
        val mid = (right - left) / 2 + left
        when {
            n > (mid + 2).toLong() * (mid + 1) / 2 - 1 -> left = mid + 1
            n < mid.toLong() * (mid + 1) / 2 -> right = mid - 1
            else -> return mid
        }
    }
    return left
}


fun main() {
//    repeat(10) {
//        println(arrangeCoins(it))
//    }
    println(arrangeCoins(1804289383))
}