package leetcode

/*
编写一个程序，通过填充空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 ' ' 表示。

53  7    
6  195   
 98    6 
8   6   3
4  8 3  1
7   2   6
 6    28 
   419  5
    8  79

534678912
672195348
198342567
859761423
426853791
713924856
961537284
287419635
345286179

提示：
给定的数独序列只包含数字 1-9 和字符 ' ' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn com/problems/sudoku-solver
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 0~81一个个试，不行就回溯
 */
private fun solveSudoku(board: Array<CharArray>): Unit {
    fun dfs(index: Int): Boolean {
        if (index == 81) return true
        val (x, y) = index / 9 to index % 9
        if (board[x][y] != '.') return dfs(index + 1)

        // 拿到可以填的点
        val arr = BooleanArray(9)
        repeat(9) {
            if (board[x][it] != '.') arr[board[x][it] - '1'] = true
            if (board[it][y] != '.') arr[board[it][y] - '1'] = true
        }
        repeat(3) { a ->
            repeat(3) { b ->
                if (board[x / 3 * 3 + a][y / 3 * 3 + b] != '.') {
                    arr[board[x / 3 * 3 + a][y / 3 * 3 + b] - '1'] = true
                }
            }
        }
        for (a in 0..8) {
            if (!arr[a]) {
                board[x][y] = '1' + a
                if (dfs(index + 1)) return true
                board[x][y] = '.'
            }
        }
        return false
    }
    dfs(0)
}

fun main() {
    arrayOf(
        "53..7....".toCharArray(),
        "6..195...".toCharArray(),
        ".98....6.".toCharArray(),
        "8...6...3".toCharArray(),
        "4..8.3..1".toCharArray(),
        "7...2...6".toCharArray(),
        ".6....28.".toCharArray(),
        "...419..5".toCharArray(),
        "....8..79".toCharArray(),
    ).apply(::solveSudoku).map { it.joinToString(" ") }.forEach(::println)
    println("*********************")
    arrayOf(
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
        ".........".toCharArray(),
    ).apply(::solveSudoku).map { it.joinToString(" ") }.forEach(::println)
    println("*********************")
    arrayOf(
        "53..7....".toCharArray(),
        "6..195...".toCharArray(),
        ".98....6.".toCharArray(),
        "8...6...3".toCharArray(),
        "4..8.3..1".toCharArray(),
        "7...2...6".toCharArray(),
        ".6....28.".toCharArray(),
        "...419..5".toCharArray(),
        "....8..79".toCharArray(),
    ).apply(::solveSudoku).map { it.joinToString(" ") }.forEach(::println)
}