package leetcode

/*
给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。

示例 1：
输入：arr = [2,6,4,1]
输出：false
解释：不存在连续三个元素都是奇数的情况。

示例 2：
输入：arr = [1,2,34,3,4,5,7,23,12]
输出：true
解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。

提示：
1 <= arr.length <= 1000
1 <= arr[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/three-consecutive-odds
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var count = 0
    for (i in arr) {
        if (i % 2 == 0) {
            count = 0
        } else {
            count++
        }
        if (count == 3) {
            return true
        }
    }
    return false
}

fun main() {
    println(threeConsecutiveOdds(intArrayOf(2, 6, 4, 1)))
    println(threeConsecutiveOdds(intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)))
}