package leetcode

/*
每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。

示例 1：
输入：5
输出：2
解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。

示例 2：
输入：7
输出：0
解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。

示例 3：
输入：10
输出：5
解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
 
提示：
0 <= N < 10^9
本题与 476：https://leetcode-cn.com/problems/number-complement/ 相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/complement-of-base-10-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun bitwiseComplement(N: Int): Int {
    var temp = N
    var res = 1
    while (temp != 0) {
        temp /= 2
        res *= 2
    }
    return res - 1 - N
}

fun main() {
    println(bitwiseComplement(5))
    println(bitwiseComplement(7))
    println(bitwiseComplement(10))
}
/*
101 -> 010 111 - 101
111 -> 000 111 - 111
1010 -> 0101 1010 - 0101

 */