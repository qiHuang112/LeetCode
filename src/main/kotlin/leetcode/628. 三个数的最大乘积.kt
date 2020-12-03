package leetcode

/*
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun maximumProduct(nums: IntArray): Int {
    // 找出数组的最小两个数和最大三个数的索引
    var (min1, min2, max1, max2, max3) = arrayOf(-1, -1, -1, -1, -1)
    for (i in nums.indices) {
        when {
            min1 == -1 -> min1 = i
            nums[min1] > nums[i] -> {
                min2 = min1
                min1 = i
            }
            min2 == -1 -> min2 = i
            nums[min2] > nums[i] -> min2 = i
        }
        when {
            max1 == -1 -> max1 = i
            nums[max1] < nums[i] -> {
                max3 = max2
                max2 = max1
                max1 = i
            }
            max2 == -1 -> max2 = i
            nums[max2] < nums[i] -> {
                max3 = max2
                max2 = i
            }
            max3 == -1 -> max3 = i
            nums[max3] < nums[i] -> max3 = i
        }
    }
    return maxOf(nums[min1] * nums[min2] * nums[max1], nums[max1] * nums[max2] * nums[max3])
}

fun main() {
    println(maximumProduct(intArrayOf(1, 2, 3)))
    println(maximumProduct(intArrayOf(1, 2, 3, 4)))
    println(maximumProduct(intArrayOf(3, 4, 0, 0, -1, -5)))
}