package leetcode

/*
下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。

示例1:
 输入：num = 2（或者0b10）
 输出：[4, 1] 或者（[0b100, 0b1]）

示例2:
 输入：num = 1
 输出：[2, -1]

提示:
num的范围在[1, 2147483647]之间；
如果找不到前一个或者后一个满足条件的正数，那么输出 -1。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/closed-number-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findClosedNumbers(num: Int): IntArray {
    // 求较大的数
    var temp = num
    var count0 = 0
    var count1 = 0
    while (temp.and(1) == 0) {
        temp = temp.shr(1)
        count0++
    }
    while (temp.and(1) != 0) {
        temp = temp.shr(1)
        count1++
    }
    var a = (temp + 1L).shl(count0 + count1) + 1.shl(count1 - 1) - 1
    if (a > Int.MAX_VALUE) a = -1

    // 求较小的数
    val b = when {
        num.and(num + 1) == 0 -> -1L
        else -> {
            temp = num
            count0 = 0
            count1 = 0
            while (temp.and(1) != 0) {
                temp = temp.shr(1)
                count1++
            }
            while (temp.and(1) == 0) {
                temp = temp.shr(1)
                count0++
            }
            temp = num.and(num + 1)
            (1L.shl(count1 + 1) - 1).shl(count0 - 1) + temp.and(temp - 1)
        }
    }
    return intArrayOf(a.toInt(), b.toInt())
}

fun main() {
    println(findClosedNumbers(2).map(Integer::toBinaryString))
    println(findClosedNumbers(1).map(Integer::toBinaryString))
    println(findClosedNumbers(0b011010).map(Integer::toBinaryString))
    println(findClosedNumbers(0b1101101100001110110110100100001).map(Integer::toBinaryString))
    println(findClosedNumbers(571603719).contentToString())
}
/*
100010000100011111101100000111
100010000100011111101100001011
100010000100011111101011110000
100010000100011111101100001110
100010000100011111101100010011
 */