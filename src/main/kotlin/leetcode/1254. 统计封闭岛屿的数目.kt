package leetcode

/*
有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
请返回封闭岛屿的数目。

示例 1：
输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
输出：2
解释：
灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。

示例 2：
输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
输出：1

示例 3：
输入：grid = [[1,1,1,1,1,1,1],
             [1,0,0,0,0,0,1],
             [1,0,1,1,1,0,1],
             [1,0,1,0,1,0,1],
             [1,0,1,1,1,0,1],
             [1,0,0,0,0,0,1],
             [1,1,1,1,1,1,1]]
输出：2
 
提示：
1 <= grid.length, grid[0].length <= 100
0 <= grid[i][j] <=1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-closed-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun closedIsland(grid: Array<IntArray>): Int {
    fun dfs(i: Int, j: Int) {
        if (i !in grid.indices || j !in grid[i].indices || grid[i][j] == 1) {
            return
        }
        grid[i][j] = 1
        dfs(i + 1, j)
        dfs(i, j + 1)
        dfs(i - 1, j)
        dfs(i, j - 1)
    }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 0 && ((i == 0 || i == grid.lastIndex) || (j == 0 || j == grid[i].lastIndex))) {
                dfs(i, j)
            }
        }
    }
    var res = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 0) {
                res++
                dfs(i, j)
            }
        }
    }
    return res
}

fun main() {
    println(
        closedIsland(
            arrayOf(
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
                intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
                intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
            )
        )
    )
    println(
        closedIsland(
            arrayOf(
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 1, 0),
            )
        )
    )
    println(
        closedIsland(
            arrayOf(
                intArrayOf(1, 1, 1, 1, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 0, 0, 1),
                intArrayOf(1, 0, 1, 1, 1, 0, 1),
                intArrayOf(1, 0, 1, 0, 1, 0, 1),
                intArrayOf(1, 0, 1, 1, 1, 0, 1),
                intArrayOf(1, 0, 0, 0, 0, 0, 1),
                intArrayOf(1, 1, 1, 1, 1, 1, 1),
            )
        )
    )
}