package leetcode

/*
集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

示例 1:
输入: nums = [1,2,2,4]
输出: [2,3]
注意:

给定数组的长度范围是 [2, 10000]。
给定的数组是无序的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-mismatch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 索引标记法
 * 数组中的1代表索引0
 * 数组中的n代表索引n-1
 * 遍历数组，将遍历到的索引对应的数字取反
 * 标记完之后，两个没有被标记的索引就是结果
 * 如何找重复的数字呢？
 * 如果sum(nums) 比 1+..+n大，则较大的重复，反之较小的重复
 */
private fun findErrorNums(nums: IntArray): IntArray {
    var sum = 0
    for (i in nums.indices) {
        nums[nums[i].let(Math::abs) - 1] *= -1
        sum += nums[i].let(Math::abs)
    }
    val (m, n) = nums.indices.filter { nums[it] > 0 }
    if (sum > nums.size * (nums.size + 1) / 2) {
        return intArrayOf(n + 1, m + 1)
    }
    return intArrayOf(m + 1, n + 1)
}

fun main() {
    println(findErrorNums(intArrayOf(1, 2, 2, 4)).contentToString())
    println(findErrorNums(intArrayOf(1, 3, 3, 4)).contentToString())
}