package leetcode

/*
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：
输入：[1,2,5,9,5,9,5,5,5]
输出：5

示例 2：
输入：[3,2]
输出：-1

示例 3：
输入：[2,2,1,1,1,2,2]
输出：2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-majority-element-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun majorityElement(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    var res = nums[0]
    var count = 1
    for (i in 1..nums.lastIndex) {
        if (count == 0) {
            res = nums[i]
        }
        if (res != nums[i]) {
            count--
        } else {
            count++
        }
    }
    if (2 * nums.count { it == res } > nums.size) {
        return res
    }
    return -1
}

fun main() {
    println(majorityElement(intArrayOf(1, 2, 5, 9, 5, 9, 5, 5, 5)))
    println(majorityElement(intArrayOf(3, 2)))
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}