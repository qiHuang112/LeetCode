package leetcode

/*
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]

示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]

限制：
1 <= target <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findContinuousSequence(target: Int): Array<IntArray> {
    val res = mutableListOf<IntArray>()
    for (i in 1..target / 2) {
        for (j in i + 1..target / 2 + 1) {
            val cur = (i + j) * (j - i + 1) / 2
            if (cur > target) break
            if (cur == target) {
                res.add(IntArray(j - i + 1) { it + i })
                break
            }
        }
    }
    return res.toTypedArray()
}

fun main() {
    findContinuousSequence(9).map(IntArray::contentToString).forEach(::println)
    findContinuousSequence(15).map(IntArray::contentToString).forEach(::println)
}