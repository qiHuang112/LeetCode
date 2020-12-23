package leetcode

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

进阶：
你可以不使用代码库中的排序函数来解决这道题吗？
你能想出一个仅使用常数空间的一趟扫描算法吗？

示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]

示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]

示例 3：
输入：nums = [0]
输出：[0]

示例 4：
输入：nums = [1]
输出：[1]
 
提示：
n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 鲁莽两次遍历
 */
private fun sortColors1(nums: IntArray): Unit {
    var count0 = 0
    var count1 = 0
    var count2 = 0
    for (i in nums.indices) {
        when (nums[i]) {
            0 -> count0++
            1 -> count1++
            2 -> count2--
        }
    }
    for (i in 0 until count0) {
        nums[i] = 0
    }
    for (i in count0 until count0 + count1) {
        nums[i] = 1
    }
    for (i in count0 + count1..nums.lastIndex) {
        nums[i] = 2
    }
}

/**
 * 双指针单次遍历
 */
private fun sortColors(nums: IntArray): Unit {
    var p0 = 0
    var p2 = nums.lastIndex
    var index = 0
    while (index <= p2) {
        while (index <= p2 && nums[index] == 2) {
            nums.swap(index, p2--)
        }
        if (nums[index] == 0) {
            nums.swap(index, p0++)
        }
        index++
    }
}

private fun IntArray.swap(a: Int, b: Int) {
    val temp = this[a]
    this[a] = this[b]
    this[b] = temp
}


fun main() {
//    intArrayOf(2, 0, 2, 1, 1, 0).apply(::sortColors).let(IntArray::contentToString).let(::println)
//    intArrayOf(2, 0, 1).apply(::sortColors).let(IntArray::contentToString).let(::println)
//    intArrayOf(0).apply(::sortColors).let(IntArray::contentToString).let(::println)
//    intArrayOf(1).apply(::sortColors).let(IntArray::contentToString).let(::println)
    intArrayOf(1, 2, 0).apply(::sortColors).let(IntArray::contentToString).let(::println)
}