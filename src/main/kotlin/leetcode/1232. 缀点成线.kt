package leetcode

/*
在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。

示例 1：
输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
输出：true

示例 2：
输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
输出：false

提示：
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates 中不含重复的点

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    if (coordinates[0][0] == coordinates[1][0]) return coordinates.all { it[0] == coordinates[0][0] }
    if (coordinates[0][1] == coordinates[1][1]) return coordinates.all { it[1] == coordinates[0][1] }
    val k = 1.0 * (coordinates[0][1] - coordinates[1][1]) / (coordinates[0][0] - coordinates[1][0])
    val b = coordinates[0][1] - k * coordinates[0][0]
    return coordinates.all { k * it[0] + b - it[1] == 0.0 }
}

fun main() {
    println(
        checkStraightLine(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7),
            )
        )
    )
    println(
        checkStraightLine(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(7, 7),
            )
        )
    )
}