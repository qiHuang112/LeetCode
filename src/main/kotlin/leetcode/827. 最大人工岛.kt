package leetcode

/*
在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）

示例 1:
输入: [[1, 0], [0, 1]]
输出: 3
解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。

示例 2:
输入: [[1, 1], [1, 0]]
输出: 4
解释: 将一格0变成1，岛屿的面积扩大为 4。

示例 3:
输入: [[1, 1], [1, 1]]
输出: 4
解释: 没有0可以让我们变成1，面积依然为 4。

说明:
1 <= grid.length = grid[0].length <= 50
0 <= grid[i][j] <= 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/making-a-large-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：遍历岛屿，然后小岛屿连接
 */
private fun largestIsland(grid: Array<IntArray>): Int {
    val islands = mutableListOf<Int>()
    val offset = 3
    var index = 0
    fun isValid(i: Int, j: Int): Boolean {
        return i in grid.indices && j in grid[i].indices
    }

    fun dfs(i: Int, j: Int): Int {
        if (!isValid(i, j) || grid[i][j] != 1) {
            return 0
        }
        grid[i][j] = offset + index
        return 1 + dfs(i + 1, j) + dfs(i, j + 1) + dfs(i - 1, j) + dfs(i, j - 1)
    }

    fun getNeighborArr(i: Int, j: Int): Int {
        val set = mutableSetOf<Int>()
        val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        var res = 1
        for (d in directions) {
            if (isValid(i + d[0], j + d[1]) && grid[i + d[0]][j + d[1]] != 0 && set.add(grid[i + d[0]][j + d[1]])) {
                res += islands[grid[i + d[0]][j + d[1]] - offset]
            }
        }
        return res
    }

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                islands.add(dfs(i, j))
                index++
            }
        }
    }
    if (islands.isEmpty()) return 1
    var res = islands[0]
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 0) {
                res = maxOf(res, getNeighborArr(i, j))
            }
        }
    }

    return res
}

fun main() {
    println(
        largestIsland(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1),
            )
        )
    )
    println(
        largestIsland(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 0),
            )
        )
    )
    println(
        largestIsland(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 1),
            )
        )
    )
    println(
        largestIsland(
            arrayOf(
                intArrayOf(1, 1, 0, 0, 1, 1),
                intArrayOf(1, 1, 1, 1, 0, 1),
                intArrayOf(1, 0, 0, 1, 0, 1),
                intArrayOf(1, 0, 0, 1, 0, 1),
                intArrayOf(0, 1, 1, 0, 0, 1),
            )
        )
    )
}
/*
1, 1, 0, 0, 1, 1
1, 1, 1, 1, 0, 1
1, 0, 0, 1, 0, 1
1, 0, 0, 1, 0, 1
0, 1, 1, 0, 0, 1

1, 1, 0, 0, 2, 2
1, 1, 1, 1, 0, 2
1, 0, 0, 1, 0, 2
0, 0, 0, 1, 0, 2
0, 3, 3, 0, 0, 2
 */