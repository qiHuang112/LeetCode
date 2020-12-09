package leetcode

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]

示例 2:
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]

说明：
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。
进阶：

如果给定的数组已经排好序呢？你将如何优化你的算法？
如果 nums1 的大小比 nums2 小很多，哪种方法更优？
如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map1 = mutableMapOf<Int, Int>()
    val map2 = mutableMapOf<Int, Int>()
    val res = mutableListOf<Int>()
    for (i in nums1) {
        map1[i] = map1.getOrDefault(i, 0) + 1
    }
    for (i in nums2) {
        map2[i] = map2.getOrDefault(i, 0) + 1
    }
    for (key in map1.keys) {
        if (key in map2.keys) {
            repeat(minOf(map1[key]!!, map2[key]!!)) {
                res.add(key)
            }
        }
    }
    return res.toIntArray()
}

fun main() {
    println(intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentToString())
    println(intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentToString())
}