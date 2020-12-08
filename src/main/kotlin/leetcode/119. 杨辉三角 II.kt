package leetcode

/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 3
输出: [1,3,3,1]

进阶：
你可以优化你的算法到 O(k) 空间复杂度吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pascals-triangle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex == 0) return listOf(1)
    var cur = 0
    var res = listOf(1)
    while (rowIndex > cur) {
        cur++
        res = List(res.size + 1) { index ->
            when (index) {
                0, res.size -> 1
                else -> res[index] + res[index - 1]
            }
        }
    }
    return res
}

fun main() {
    for (i in 1..10) {
        println(getRow(i))
    }
}