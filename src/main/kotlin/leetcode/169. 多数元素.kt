package leetcode

/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:
输入: [3,2,3]
输出: 3

示例 2:
输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun majorityElement(nums: IntArray): Int {
    var res = nums[0]
    var count = 1
    for (i in 1..nums.lastIndex) {
        if (nums[i] == res) {
            count++
        } else {
            if (count == 0) {
                res = nums[i]
                count = 1
            } else {
                count--
            }
        }
    }
    return res
}

fun main() {
    println(majorityElement(intArrayOf(3, 2, 3)))
    println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}