package leetcode

/*
给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
子数组 定义为原数组中的一个连续子序列。
请你返回 arr 中 所有奇数长度子数组的和 。

示例 1：
输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

示例 2：
输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。

示例 3：
输入：arr = [10,11,12]
输出：66

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun sumOddLengthSubarrays(arr: IntArray): Int {
    val count = IntArray(arr.size)
    // i -> 当前奇数
    for (i in 1..arr.size step 2) {
        // j -> 开始索引
        for (j in 0..arr.size - i) {
            // count++
            for (k in j until j + i) {
                count[k]++
            }
        }
    }
    return arr.foldIndexed(0) { index, acc, i ->
        acc + count[index] * i
    }
}

fun main() {
    println(sumOddLengthSubarrays(intArrayOf(1, 4, 2, 5, 3)))
    println(sumOddLengthSubarrays(intArrayOf(1, 2)))
    println(sumOddLengthSubarrays(intArrayOf(10, 11, 12)))
}
/*
长度为9
1: 1+1+1+1+1+1+1+1+1
3: 1+2+3+3+3+3+3+2+1
5: 1+2+3+4+5+4+3+2+1
7: 1+2+3+3+3+3+3+2+1
9: 1+1+1+1+1+1+1+1+1
长度为8
1: 1+1+1+1+1+1+1+1
3: 1+2+3+3+3+3+2+1
5: 1+2+3+4+4+3+2+1
7: 1+2+2+2+2+2+2+1
长度为7
1: 1+1+1+1+1+1+1
3: 1+2+3+3+3+2+1
5: 1+2+3+3+3+2+1
7: 1+1+1+1+1+1+1
长度为6
1: 1+1+1+1+1+1
3: 1+2+3+3+2+1
5: 1+2+2+2+2+1
长度为5
1: 1+1+1+1+1
3: 1+2+3+2+1
5: 1+1+1+1+1
长度为4
1: 1+1+1+1
3: 1+2+2+1
长度为3
1: 1+1+1
3: 1+2+1
长度为2
1: 1+1
 */