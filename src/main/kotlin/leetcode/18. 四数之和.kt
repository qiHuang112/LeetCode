package leetcode

/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：
答案中不可以包含重复的四元组。

示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 直接鲁莽暴力结题
 * 时间复杂度 o(n^4)
 */
private fun fourSum1(nums: IntArray, target: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    for (i in 0..nums.lastIndex) {
        for (j in i + 1..nums.lastIndex) {
            for (m in j + 1..nums.lastIndex) {
                for (n in m + 1..nums.lastIndex) {
                    if (target == nums[i] + nums[j] + nums[m] + nums[n]) {
                        res.add(listOf(nums[i], nums[j], nums[m], nums[n]))
                    }
                }
            }
        }
    }
    return res
}

private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return emptyList()
    val res = mutableListOf<List<Int>>()
    nums.sort()
    for (a in 0..nums.lastIndex - 3) {
        if (a > 0 && nums[a] == nums[a - 1]) continue
        for (b in a + 1..nums.lastIndex - 2) {
            if (b > a + 1 && nums[b] == nums[b - 1]) continue
            for (c in b + 1 until nums.lastIndex) {
                if (c > b + 1 && nums[c] == nums[c - 1]) continue
                var d = nums.lastIndex
                while (d > c + 1 && nums[a] + nums[b] + nums[c] + nums[d] > target) {
                    d--
                }
                if (d > c && nums[a] + nums[b] + nums[c] + nums[d] == target) {
                    res.add(listOf(nums[a], nums[b], nums[c], nums[d]))
                }
            }
        }
    }
    return res
}

fun main() {
    println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
}
/*
-2,-1,0,0,1,2
 */