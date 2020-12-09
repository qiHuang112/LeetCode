package leetcode

/*
给定一个整数 n，返回 n! 结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 分析，阶乘后面的0由因子 5 和 2 组成，
 * 对于一个阶乘来说，2的因子数远多于5的因子数
 * 所以有多少个5出现，就有多少个0
 */
private fun trailingZeroes(n: Int): Int {
    var res = 0
    var temp = n
    while (temp != 0) {
        temp /= 5
        res += temp
    }
    return res
}

fun main() {
    println(trailingZeroes(5))
    println(trailingZeroes(3))
    println(trailingZeroes(26))
}
/*
1~4 -> 0
5~9 -> 1
10~14->2
15~19->3
20~24->4
25~29->6
 */