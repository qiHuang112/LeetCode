package leetcode

/*
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

示例 1:
输入: [1,2,0]
输出: 3

示例 2:
输入: [3,4,-1,1]
输出: 2

示例 3:
输入: [7,8,9,11,12]
输出: 1

提示：
你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-missing-positive
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1.不在[1..nums.size]的数全转成nums.size+1
 * 2.遍历所有数，将在区间的数-1当做index，并将对应index的数标记为负数
 * 3.遍历所有数，找出第一个为正数的索引index，返回index+1即可
 */
private fun firstMissingPositive(nums: IntArray): Int {
    // 1.不在[1..nums.size]的数全转成nums.size+1
    for (i in nums.indices) {
        if (nums[i] !in 1..nums.size) {
            nums[i] = nums.size + 1
        }
    }
    // 2.遍历所有数，将在区间的数-1当做index，并将对应index的数标记为负数
    for (i in nums.indices) {
        val index = nums[i].let(Math::abs) - 1
        if (index in nums.indices) {
            nums[index] = -(nums[index].let(Math::abs))
        }
    }
    // 3.遍历所有数，找出第一个为正数的索引index，返回index+1即可
    for (i in nums.indices) {
        if (nums[i] > 0) return i + 1
    }
    return nums.size + 1
}

fun main() {
    println(firstMissingPositive(intArrayOf(1, 2, 0)))
    println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
    println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
}
/*
1 2 0 -> 1 2 4
1 2 4 -> -1 -2 4

3 4 -1 1 -> 3 4 5 1
3 4 5 1 -> -3 4 -5 -1

 */