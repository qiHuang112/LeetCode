package leetcode

/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

示例:
输入: [2,1,5,6,2,3]
输出: 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun largestRectangleArea(heights: IntArray): Int {
    var res = 0
    for (i in heights.indices) {
        var min = heights[i]
        for (j in i..heights.lastIndex) {
            min = minOf(heights[j], min)
            res = maxOf(res, min * (j - i + 1))
        }
    }
    return res
}

fun main() {
    println(largestRectangleArea(intArrayOf(2, 1, 5, 6, 2, 3)))
}