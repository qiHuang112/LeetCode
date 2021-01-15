package leetcode

/*
设计一个算法，算出 n 阶乘有多少个尾随零。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun trailingZeroes(n: Int): Int {
    var res = 0
    var temp = n
    while (temp >= 5) {
        temp /= 5
        res += temp
    }
    return res
}

fun main() {
    println(trailingZeroes(3))
    println(trailingZeroes(5))
    println(trailingZeroes(300))
}