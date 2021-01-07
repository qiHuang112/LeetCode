package leetcode

/*
在一根无限长的数轴上，你站在0的位置。终点在target的位置。
每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
返回到达终点需要的最小移动次数。

示例 1:
输入: target = 3
输出: 2
解释:
第一次移动，从 0 到 1 。
第二次移动，从 1 到 3 。

示例 2:
输入: target = 2
输出: 3
解释:
第一次移动，从 0 到 1 。
第二次移动，从 1 到 -1 。
第三次移动，从 -1 到 2 。

注意:
target是在[-10^9, 10^9]范围中的非零整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reach-a-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 假设走了i次能到达target,那么走i次能到达的所有结果能构成公差为2的等差数列
 * ex: i=2 -> [1,3]
 * -1-2 -> -3
 * +1-2 -> -1
 * -1+2 -> 1
 * +1+2 -> 3
 * ex: i=3 ->[0,2,4,6]
 * -1-2-3 -> -6
 * +1-2-3 -> -4
 * -1+2-3 -> -2
 * -1+2-3 -> 0
 * 1-2+3 -> 2
 * -1+2+3 -> 4
 * +1+2+3 -> 6
 * i=4 -> [0,2,4,6,8,10]
 * i=5 -> [1,3,5,7,9,11,13,15]
 * i=6 -> [1,3,5,7,9,11,13,15,17,19,21]
 */
private fun reachNumber(target: Int): Int {
    val target = target.let(Math::abs)
    var total = 1
    var res = 1
    while (total < target || (total - target) % 2 != 0) {
        res++
        total += res
    }
    return res
}

fun main() {
    for (i in 1..10) {
        println("target:$i, step:" + reachNumber(i))
    }
}
