package leetcode

import java.util.*

/*
爱丽丝有一手（hand）由整数数组给定的牌。 
现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
如果她可以完成分组就返回 true，否则返回 false。

注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

示例 1：
输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
输出：true
解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。

示例 2：
输入：hand = [1,2,3,4,5], W = 4
输出：false
解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 
提示：
1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hand-of-straights
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 优先队列
 */
private fun isNStraightHand(hand: IntArray, W: Int): Boolean {
    val queue = PriorityQueue<Int>()
    for (i in hand) {
        queue.offer(i)
    }
    while (queue.isNotEmpty()) {
        val cur = queue.peek()
        for (i in 0 until W) {
            if (!queue.remove(cur + i)) {
                return false
            }
        }
    }
    return true
}

fun main() {
    println(isNStraightHand(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3))
    println(isNStraightHand(intArrayOf(1, 2, 3, 4, 5), 4))
}