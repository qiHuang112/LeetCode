package leetcode

/*
设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。

示例 1:
输入: nums = [5,6,5], target = 11
输出: [[5,6]]

示例 2:
输入: nums = [5,6,5,6], target = 11
输出: [[5,6],[5,6]]

提示：
nums.length <= 100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun pairSums(nums: IntArray, target: Int): List<List<Int>> {
    val map = nums.fold(mutableMapOf<Int, Int>()) { acc, i ->
        acc.apply {
            this[i] = (this[i] ?: 0) + 1
        }
    }
    val res = mutableListOf<List<Int>>()
    for (key in map.keys) {
        if (map[target - key] != null) {
            val count = if (key == target - key) {
                map[key]!! / 2
            } else {
                minOf(map[key]!!, map[target - key]!!)
            }
            repeat(count) {
                res.add(listOf(key, target - key))
            }
            map[key] = 0
            map[target - key] = 0
        }
    }
    return res
}

fun main() {
    println(pairSums(intArrayOf(5, 6, 5), 11))
    println(pairSums(intArrayOf(5, 6, 5, 6), 11))
}