package leetcode

/*
设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。

示例:
输入: a = 1, b = 1
输出: 2
 

提示：
a, b 均可能是负数或 0
结果不会溢出 32 位整数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-without-plus-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun add(a: Int, b: Int): Int {
    if (b == 0) return a
    return add(a xor b, (a and b) shl 1)
}

fun main() {
    println(add(1, 1))
    println(add(18, 21))
}
/*
1 1
a xor b -> 0
(a and b) shl 1 -> 2

1 2
a xor b -> 11
(a and b) shl 1 -> 0

0 2

 */
