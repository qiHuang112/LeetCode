package leetcode

/*
给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。

示例：

输入:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

输出:
6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/elimination-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun lastRemaining(n: Int): Int {
    return getRes(n, true)
}

/**
 * flag为true表示从第一个往后删
 * false表示从最后一个往前删
 */
private fun getRes(n: Int, flag: Boolean): Int {
    if (n == 1) return 1
    return 2 * getRes(n / 2, !flag) + if (flag) 0 else n % 2 - 1
}

fun main() {
    for (i in 1..20) {
        println(lastRemaining(i))
    }
}