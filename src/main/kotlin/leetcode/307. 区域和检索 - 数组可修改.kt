package leetcode

/*
给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

示例:
Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

说明:
数组仅可以在 update 函数下进行修改。
你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-mutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * todo qrt 分解  线段树实现
 */
private class NumArray(val nums: IntArray) {

    val arr: IntArray = IntArray(nums.size)

    init {
        var cur = 0
        for (i in nums.indices) {
            cur += nums[i]
            arr[i] = cur
        }
    }

    fun update(i: Int, `val`: Int) {
        for (j in i..arr.lastIndex) {
            arr[j] += `val` - nums[i]
        }
        nums[i] = `val`
    }

    fun sumRange(i: Int, j: Int): Int {
        if (i == 0) return arr[j]
        return arr[j] - arr[i - 1]
    }

}

fun main() {
    NumArray(intArrayOf(1, 3, 5)).apply {
        sumRange(0, 2).let(::println)
        update(1, 2).let(::println)
        sumRange(0, 2).let(::println)
    }
}