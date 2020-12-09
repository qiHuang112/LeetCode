package leetcode

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
 
说明：
输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 哈希
 */
private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toSet()
    val set2 = nums2.toSet()
    val res = set1 - (set1 - set2)
    return res.toIntArray()
}

fun main() {
    println(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentToString())
    println(intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentToString())
    println(intersection(intArrayOf(), intArrayOf(9, 4, 9, 8, 4)).contentToString())
}