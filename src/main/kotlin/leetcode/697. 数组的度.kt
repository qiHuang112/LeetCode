package leetcode

/*
给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:
输入: [1, 2, 2, 3, 1]
输出: 2
解释:
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.

示例 2:
输入: [1,2,2,3,1,4,2]
输出: 6

注意:
nums.length 在1到50,000区间范围内。
nums[i] 是一个在0到49,999范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/degree-of-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Number(var count: Int = 0, var start: Int = -1, var end: Int = -1)

private fun findShortestSubArray(nums: IntArray): Int {
    val list = mutableListOf<Number>()
    var max = 0
    nums.foldIndexed(mutableMapOf<Int, Number>()) { i, acc, num ->
        val number = acc.getOrDefault(num, Number())
        if (number.start == -1) {
            number.start = i
            number.end = i
        } else {
            number.end = i
        }
        number.count++
        if (number.count > max) {
            list.clear()
            list.add(number)
            max = number.count
        } else if (number.count == max) {
            list.add(number)
        }
        acc[num] = number
        acc
    }
    return list.map { it.end - it.start + 1 }.reduce(::minOf)
}

fun main() {
    println(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1)))
    println(findShortestSubArray(intArrayOf(1, 2, 2, 3, 1, 4, 2)))
    println(findShortestSubArray(intArrayOf(1)))
}