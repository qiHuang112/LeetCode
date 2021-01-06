package leetcode

import java.util.*

/*
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:
nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
进阶：
如果给定的数组中含有负数会怎么样？
问题会产生什么变化？
我们需要在题目中添加什么限制来允许负数的出现？

致谢：
特别感谢 @pbrother 添加此问题并创建所有测试用例。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 超时了
 * 深度优先搜索超时了
 * 尝试用动态规划
 */
private fun combinationSum41(nums: IntArray, target: Int): Int {
    var count = 0
    val repeated = LinkedList<Int>()
    fun dfs(index: Int, cur: Int) {
        if (index == nums.size) {
            if (cur == 0) {
                count += getCount(repeated)
            }
            return
        }
        for (i in 0..cur / nums[index]) {
            repeated.addLast(i)
            dfs(index + 1, cur - i * nums[index])
            repeated.removeLast()
        }
    }
    dfs(0, target)
    return count
}

/**
 * 根据每个数字选择的个数，计算所有排列
 * 如 :
 * repeated:[0, 2, 0] -> 返回1
 * 解释：从三个数中选，第一个数选0个，第二个数选2个，第三个数选0个，有多少种不重复排列
 * repeated:[2, 1, 0] -> 返回3
 * 解释：从三个数中选，第一个数选2个，第二个数选1个，第三个数选0个，有多少种不重复排列
 * repeated:[2, 1, 1] -> 返回12
 * 解释：从三个数中选，第一个数选2个，第二个数选1个，第三个数选1个，有多少种不重复排列
 *
 */
private fun getCount(repeated: LinkedList<Int>): Int {
    var count = 0
    var res = 1
    for (num in repeated) {
        for (i in 1..num) {
            res = res * (count + i) / i
        }
        count += num
    }
    println("$res:$repeated")
    return res
}

/**
 * 动态规划
 */
private fun combinationSum4(nums: IntArray, target: Int): Int {
    val dp = IntArray(target + 1)
    dp[0] = 1
    for (i in 1..target) {
        for (num in nums) {
            dp[i] += if (num <= i) dp[i - num] else 0
        }
    }
    return dp[target]
}

fun main() {
    println(combinationSum4(intArrayOf(1, 2, 3), target = 4))
    println(combinationSum4(intArrayOf(1, 2), target = 10))
}