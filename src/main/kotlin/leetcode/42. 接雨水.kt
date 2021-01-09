package leetcode

import java.util.*

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：
输入：height = [4,2,0,3,2,5]
输出：9

提示：
n == height.length
0 <= n <= 3 * 10^4
0 <= height[i] <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/trapping-rain-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 优先队列，简单实现
 * todo:双指针实现
 */
private fun trap(height: IntArray): Int {
    if (height.size <= 2) return 0
    val queue = PriorityQueue<Int> { i, j -> height[j] - height[i] }
    var sum = 0
    for (i in height.indices) {
        queue.offer(i)
        sum += height[i]
    }
    var res = height[0] + height[height.lastIndex]
    queue.remove(0)
    for (i in 1 until height.lastIndex) {
        if (height[i] < height[i - 1]) {
            height[i] = minOf(height[queue.peek()], height[i - 1])
        }
        res += height[i]
        queue.remove(i)
    }
    return res - sum
}

fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5, 4, 2, 0, 3, 2)))
    println(trap(intArrayOf(5, 4, 1, 2)))
}