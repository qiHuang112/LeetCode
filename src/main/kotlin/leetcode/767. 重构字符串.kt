package leetcode

import java.lang.StringBuilder
import java.util.*

/*
给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
若可行，输出任意可行的结果。若不可行，返回空字符串。

示例 1:
输入: S = "aab"
输出: "aba"

示例 2:
输入: S = "aaab"
输出: ""

注意:
S 只包含小写字母并且长度在[1, 500]区间内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorganize-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 维护一个优先队列
 */
private fun reorganizeString(S: String): String {
    val map = IntArray(26)
    for (c in S) {
        map[c - 'a']++
    }
    val queue = PriorityQueue<Pair<Char, Int>> { p1, p2 -> p2.second - p1.second }
    for (i in map.indices) {
        if (map[i] != 0) {
            queue.offer('a' + i to map[i])
        }
    }
    val sb = StringBuilder()
    while (queue.size > 1) {
        val a = queue.poll()
        val b = queue.poll()
        sb.append(a.first).append(b.first)
        if (a.second - 1 > 0) {
            queue.offer(a.first to a.second - 1)
        }
        if (b.second - 1 > 0) {
            queue.offer(b.first to b.second - 1)
        }
    }
    if (queue.size == 1) {
        if (queue.peek().second > 1) {
            return ""
        }
        sb.append(queue.peek().first)
    }
    return sb.toString()

}

fun main() {
    println(reorganizeString(S = "aab"))
    println(reorganizeString(S = "aaab"))
    println(reorganizeString(S = "aaaabbbbccccd"))
}
/*
ababababccccd
abcabcabcabcd
 */