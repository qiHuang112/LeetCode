package leetcode

/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

示例 :
输入: [1,2,1,3,2,5]
输出: [3,5]

注意：
结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * 设a b 为那两个值
 * 1.全部异或 -> a ^ b
 * 2.根据最低位的1将数组分为两组
 * 3.分组后异或
 */
private fun singleNumber(nums: IntArray): IntArray {
    // 1.全部异或 得到 a ^ b
    val total = nums.reduce(Int::xor)
    // 2.求得某个数的最低位1
    val flag = total.and(-total)
    // 3.将nums根据最低位1分为两组分别异或
    var (a, b) = 0 to 0
    for (i in nums) {
        if (i.and(flag) == 0) {
            a = a.xor(i)
        } else {
            b = b.xor(i)
        }
    }
    return intArrayOf(a, b)
}

fun main() {
    println(singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).contentToString())
}