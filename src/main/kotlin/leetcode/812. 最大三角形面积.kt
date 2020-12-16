package leetcode

/*
给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。

示例:
输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
输出: 2
解释:
这五个点如下图所示。组成的橙色三角形是最大的，面积为2。

注意:

3 <= points.length <= 50.
不存在重复的点。
 -50 <= points[i][j] <= 50.
结果误差值在 10^-6 以内都认为是正确答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-triangle-area
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * 1.先组合 从n个点选三个
 * 2.在计算面积
 */
private fun largestTriangleArea(points: Array<IntArray>): Double {

    fun getLength(p1: IntArray, p2: IntArray): Double {
        val x = p1[0] - p2[0].toDouble()
        val y = p1[1] - p2[1].toDouble()
        return Math.sqrt(x * x + y * y)
    }

    fun getArea(list: MutableList<IntArray>): Double {
        val a = getLength(list[0], list[1])
        val b = getLength(list[0], list[2])
        val c = getLength(list[1], list[2])
        val p = (a + b + c) / 2
        return p * (p - a) * (p - b) * (p - c)
    }

    var largestArea = 0.0

    fun combine(arr: Array<IntArray>, temp: MutableList<IntArray>, index: Int) {
        if (temp.size == 3) {
            largestArea = maxOf(largestArea, getArea(temp))
            return
        }
        if (index == arr.size) return
        combine(arr, temp, index + 1)
        temp.add(arr[index])
        combine(arr, temp, index + 1)
        temp.removeAt(temp.lastIndex)
    }
    combine(points, mutableListOf(), 0)
    return Math.sqrt(largestArea)
}


fun main() {
    println(
        largestTriangleArea(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(1, 0),
                intArrayOf(0, 2),
                intArrayOf(2, 0)
            )
        )
    )
}