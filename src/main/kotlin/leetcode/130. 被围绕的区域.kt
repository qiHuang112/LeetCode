package leetcode

/*
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1.先把靠边上的用'A'保护起来
 * 2.再把所有'O'换成'X'
 * 3.然后把所有'A'换成'O'
 */
private fun solve(board: Array<CharArray>): Unit {
    fun dfs(i: Int, j: Int) {
        if (i !in board.indices || j !in board[i].indices || board[i][j] != 'O') return
        board[i][j] = 'A'
        dfs(i + 1, j)
        dfs(i, j + 1)
        dfs(i - 1, j)
        dfs(i, j - 1)
    }
    for (i in board.indices) {
        for (j in board[i].indices) {
            // 遍历边界所有'O'
            if (i == 0 || i == board.lastIndex || j == 0 || j == board[i].lastIndex) {
                if (board[i][j] == 'O') {
                    dfs(i, j)
                }
            }
        }
    }
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 'O') {
                board[i][j] = 'X'
            }
            if (board[i][j] == 'A') {
                board[i][j] = 'O'
            }
        }
    }
}

fun main() {
    arrayOf(
        "XXXX".toCharArray(),
        "XOOX".toCharArray(),
        "XXOX".toCharArray(),
        "XOXX".toCharArray(),
    ).apply(::solve).forEach(::println)
}