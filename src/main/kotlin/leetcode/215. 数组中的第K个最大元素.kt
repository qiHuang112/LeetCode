package leetcode

import java.util.*

/*
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1.优先队列
 */
private fun findKthLargest(nums: IntArray, k: Int): Int {
    val queue = PriorityQueue<Int> { a, b -> b - a }
    nums.forEach { queue.offer(it) }
    for (i in 1 until k) {
        queue.poll()
    }
    return queue.peek()
}

/**
 * 2.排序
 */
private fun findKthLargest2(nums: IntArray, k: Int): Int {
    nums.sortDescending()
    return nums[k - 1]
}

/**
 * 3.实现大顶堆
 */
private fun findKthLargest3(nums: IntArray, k: Int): Int {
    TODO()
}

/**
 * 4.实现快排
 */
private fun findKthLargest4(nums: IntArray, k: Int): Int {
    TODO()
}

fun main() {
    println(findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}