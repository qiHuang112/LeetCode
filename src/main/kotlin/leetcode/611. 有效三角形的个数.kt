package leetcode

import java.util.*

/*
给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

示例 1:
输入: [2,2,3,4]
输出: 3
解释:
有效的组合是:
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3

注意:
数组长度不超过1000。
数组里整数的范围为 [0, 1000]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-triangle-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * dfs超时了
 */
private fun triangleNumber1(nums: IntArray): Int {
    val temp = LinkedList<Int>()
    var res = 0
    fun dfs(index: Int) {
        if (temp.size == 3) {
            if (isValid(temp[0], temp[1], temp[2])) {
                res++
            }
            return
        }
        if (index == nums.size) {
            return
        }
        dfs(index + 1)
        temp.addLast(nums[index])
        dfs(index + 1)
        temp.removeLast()
    }
    dfs(0)
    return res
}

private fun isValid(a: Int, b: Int, c: Int): Boolean {
    return (a + b) > c && (a + c) > b && (b + c) > a
}

/**
 * 排序+双指针
 * 类似三数之和的思路
 */
private fun triangleNumber(nums: IntArray): Int {
    nums.sort()
    var res = 0
    for (a in 0..nums.lastIndex - 2) {
        for (b in a + 1 until nums.lastIndex) {
            var c = nums.lastIndex
            while (c > b && nums[c] >= nums[a] + nums[b]) {
                c--
            }
            if (c > b && nums[c] < nums[a] + nums[b]) {
                res += c - b
            }
        }
    }
    return res
}

fun main() {
    println(triangleNumber(intArrayOf(2, 2, 3, 4)))
    println(triangleNumber(intArrayOf(2, 2, 3, 4, 5)))
    println(triangleNumber(intArrayOf(0, 1, 1, 1)))
    println(triangleNumber(intArrayOf(1, 2, 3, 4, 5, 6)))
}
