package leetcode

/*
魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。

示例1:
 输入：nums = [0, 2, 3, 4, 5]
 输出：0
 说明: 0下标的元素为0

示例2:
 输入：nums = [1, 1, 1]
 输出：1

说明:
nums长度在[1, 1000000]之间
此题为原书中的 Follow-up，即数组中可能包含重复元素的版本

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/magic-index-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 题目并没有说明是升序，否则可以直接跳跃式查找
 */
private fun findMagicIndex(nums: IntArray): Int {
    var index = 0
    while (index < nums.size) {
        if (index == nums[index]) {
            return index
        }
        if (index < nums[index] - 1) {
            index = nums[index] - 1
        }
        index++
    }
    return -1
}

private fun findMagicIndex1(nums: IntArray): Int {
    var res = -1
    for ((i, v) in nums.withIndex()) {
        if (i == v) {
            res = i
            break
        }
    }
    return res
}

fun main() {
    println(findMagicIndex(intArrayOf(0, 2, 3, 4, 5)))
    println(findMagicIndex(intArrayOf(6, 6, 6, 6, 6, 6, 8, 8)))
    println(findMagicIndex(intArrayOf(1, 1, 1)))
}