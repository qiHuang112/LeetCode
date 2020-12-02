package leetcode

/*
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

示例 1：
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]

示例 2：
输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun sortedSquares(nums: IntArray): IntArray {
    var k = nums.lastIndex
    val res = IntArray(nums.size)
    var (i, j) = 0 to nums.size - 1
    while (k >= 0) {
        if (nums[i] * nums[i] > nums[j] * nums[j]) {
            res[k--] = nums[i] * nums[i]
            i++
        } else {
            res[k--] = nums[j] * nums[j]
            j--
        }
    }
    return res
}

fun main() {
    println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).contentToString())
    println(sortedSquares(intArrayOf(-7, -3, 2, 3, 11)).contentToString())
}