package leetcode

import kotlin.math.abs

/**
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
 */
/**
 * 思路：
 * 将值当成索引，走过的索引用负数标记，最后遍历nums，没有被负数标记的就是没有走过的索引
 */
private fun findDisappearedNumbers(nums: IntArray): List<Int> {
    for (i in nums.indices) {
        nums[abs(nums[i]) - 1] = -abs(nums[abs(nums[i]) - 1])
    }
    val res = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[i] > 0) {
            res.add(i + 1)
        }
    }
    return res
}

fun main() {
    println(findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}