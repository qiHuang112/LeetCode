package leetcode

/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun threeSum(nums: IntArray): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    if (nums.size < 3) return res
    nums.sort()
    for (a in 0..nums.lastIndex - 2) {
        if (a > 0 && nums[a] == nums[a - 1]) continue
        var c = nums.lastIndex
        for (b in a + 1 until nums.lastIndex) {
            if (b > a + 1 && nums[b] == nums[b - 1]) continue
            while (c > b + 1 && nums[a] + nums[b] + nums[c] > 0) {
                c--
            }
            if (c > b && nums[a] + nums[b] + nums[c] == 0) {
                res.add(listOf(nums[a], nums[b], nums[c]))
            }
        }
    }
    return res
}

/*
-4,-1,-1,0,1,2
 */
fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(-1, 0, 1, 1, -2, 0, 1, 1, 2, 2, -2, -1)))
}