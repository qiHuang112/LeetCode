package leetcode

/*
在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
请你返回最终形体的表面积。

示例 1：
输入：[[2]]
输出：10

示例 2：
输入：[[1,2],[3,4]]
输出：34

示例 3：
输入：[[1,0],[0,2]]
输出：16

示例 4：
输入：[[1,1,1],[1,0,1],[1,1,1]]
输出：32

示例 5：
输入：[[2,2,2],[2,1,2],[2,2,2]]
输出：46
 
提示：
1 <= N <= 50
0 <= grid[i][j] <= 50

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun surfaceArea(grid: Array<IntArray>): Int {
    var res = 0
    fun isValid(i: Int, j: Int) = i in grid.indices && j in grid[i].indices
    fun getExtra(i: Int, j: Int): Int {
        var count = 0
        val arr = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        for (a in arr) {
            if (isValid(i + a[0], j + a[1])) {
                count += minOf(grid[i][j], grid[i + a[0]][j + a[1]])
            }
        }
        return count
    }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] != 0) {
                // 上下底面积
                res += 2
                // 四周面积
                res += grid[i][j] * 4
            }
            // 重复计算的重叠面积
            res -= getExtra(i, j)
        }
    }
    return res
}

fun main() {
    /**
     * 2+4*2 = 10
     */
    println(
        surfaceArea(
            arrayOf(
                intArrayOf(2)
            )
        )
    )
    /**
     * 4*2+4*(1+2+3+4)-((1+1) + (1+2) + (2+3) + (1+3))
     * 8+40-(14) = 34
     */
    println(
        surfaceArea(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
            )
        )
    )
    /**
     * 2*2+4*(1+2)-(0+0+0+0)
     * 4+12=16
     */
    println(
        surfaceArea(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 2),
            )
        )
    )
    /**
     * 2*8+4*8-((1+1)+(1+1)+(1+1)+(1+1)+(1+1)+(1+1)+(1+1)+(1+1))
     * =32
     */
    println(
        surfaceArea(
            arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 1)
            )
        )
    )
    /**
     * 2*9+4*(8*2+1)-((2+2)+(2+2+1)+(2+2)+(2+2+1)+(1+1+1+1)+(2+2+1)+(2+2)+(2+2+1)+(2+2))
     * =46
     */
    println(
        surfaceArea(
            arrayOf(
                intArrayOf(2, 2, 2),
                intArrayOf(2, 1, 2),
                intArrayOf(2, 2, 2),
            )
        )
    )
}