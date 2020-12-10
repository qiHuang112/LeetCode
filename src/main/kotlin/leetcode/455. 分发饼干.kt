package leetcode

import kotlin.math.max

/*
假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

示例 1:
输入: g = [1,2,3], s = [1,1]
输出: 1
解释:
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。

示例 2:
输入: g = [1,2], s = [1,2,3]
输出: 2
解释:
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/assign-cookies
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 贪心算法
 * 题目立意不清晰，导致我这个代码没通过
 * 我的理解是一块饼干能分给多个孩子
 * 但是答案告诉我 一个饼干只能改一个孩子，那不就简简单单排个序，双指针解决了吗
 */
private fun findContentChildren1(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    return getRes(g, 0, s)
}

private fun getRes(g: IntArray, i: Int, s: IntArray): Int {
    if (i == g.size) return 0
    var res = 0
    for (si in s.indices) {
        if (s[si] >= g[i]) {
            s[si] -= g[i]
            res = maxOf(res, 1 + getRes(g, i + 1, s))
            s[si] += g[i]
            res = maxOf(res, getRes(g, i + 1, s))
        }
    }
    return res
}

/**
 * 先排序，因为一个饼干只给一个孩子，并且一个孩子也只有一个饼干，所以尽量省着来
 * 每次都用最少的分量给需求最小的孩子即可
 * g = [1,1,1,1,2,3,4]
 * s = [1,1,1,2]
 */
private fun findContentChildren(g: IntArray, s: IntArray): Int {
    g.sort()
    s.sort()
    var res = 0
    var (gi, si) = 0 to 0
    while (gi < g.size && si < s.size) {
        while (si < s.size && s[si] < g[gi]) {
            si++
        }
        if (si == s.size) {
            break
        }
        si++
        gi++
        res++
    }
    return res
}

fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
    println(findContentChildren(intArrayOf(1, 2), intArrayOf(1, 2, 3)))
}