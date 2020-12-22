package leetcode

/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

示例 1:
输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true

示例 2:
输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false

解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。

说明:
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-sudoku
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isValidSudoku(board: Array<CharArray>): Boolean {
    // 横向
    for (i in 0..8) {
        val map = BooleanArray(10)
        for (c in board[i]) {
            if (c == '.') continue
            if (map[c - '0']) return false
            map[c - '0'] = true
        }
    }
    // 纵向
    for (i in 0..8) {
        val map = BooleanArray(10)
        for (j in 0..8) {
            if (board[j][i] == '.') continue
            if (map[board[j][i] - '0']) return false
            map[board[j][i] - '0'] = true
        }
    }
    // 九宫格
    repeat(3) { r1 ->
        repeat(3) { r2 ->
            val map = BooleanArray(10)
            for (i in 3 * r1..3 * r1 + 2) {
                for (j in 3 * r2..3 * r2 + 2) {
                    if (board[i][j] == '.') continue
                    if (map[board[i][j] - '0']) return false
                    map[board[i][j] - '0'] = true
                }
            }
        }
    }
    return true
}

fun main() {
    println(
        isValidSudoku(
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
            ),
        )
    )
    println(
        isValidSudoku(
            arrayOf(
                "83..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray(),
            ),
        )
    )
    println(
        isValidSudoku(
            arrayOf(
                "....5..1.".toCharArray(),
                ".4.3.....".toCharArray(),
                ".....3..1".toCharArray(),
                "8......2.".toCharArray(),
                "..2.7....".toCharArray(),
                ".15......".toCharArray(),
                ".....2...".toCharArray(),
                ".2.9.....".toCharArray(),
                "..4......".toCharArray(),
            ),
        )
    )
}
/*
....5..1.
.4.3.....
.....3..1
8......2.
..2.7....
.15......
.....2...
.2.9.....
..4......
 */