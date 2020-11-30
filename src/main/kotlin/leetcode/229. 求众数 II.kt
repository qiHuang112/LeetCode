package leetcode

/*
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

示例 1：

输入：[3,2,3]
输出：[3]
示例 2：

输入：nums = [1]
输出：[1]
示例 3：

输入：[1,1,1,3,3,2,2,2]
输出：[1,2]
 */
private fun majorityElement(nums: IntArray): List<Int> {
    val res = mutableListOf<Int>()
    if (nums.isEmpty()) return res
    var a = 0 // 第一个众数
    var b = 0 // 第二个众数
    var countA = 0 // 众数A的数量
    var countB = 0 // 众数B的数量
    for (i in nums) {
        when {
            i == a -> countA++
            i == b -> countB++
            countA == 0 -> {
                a = i
                countA = 1
            }
            countB == 0 -> {
                b = i
                countB = 1
            }
            else -> {
                countA--
                countB--
            }
        }
    }
    if (nums.count { it == a } * 3 > nums.size) {
        res.add(a)
    }
    if (a != b && nums.count { it == b } * 3 > nums.size) {
        res.add(b)
    }
    return res
}

fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
    println(majorityElement(intArrayOf(1, 2)))
    println(majorityElement(intArrayOf(1)))
    println(majorityElement(intArrayOf(1, 1, 1, 3, 3, 2, 2, 2)))
    println(majorityElement(intArrayOf(0, 0, 0)))
}