package leetcode

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

提示：
board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun exist(board: Array<CharArray>, word: String): Boolean {
    // 记录每一个分支走过的路
    val map = Array(board.size) { i ->
        BooleanArray(board[i].size)
    }
    // 找到word[0]在的点
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == word[0]) {
                val res = dfs(board, map, word, i, j, 0)
                if (res) return true
            }
        }
    }
    return false
}

private fun dfs(board: Array<CharArray>, map: Array<BooleanArray>, word: String, i: Int, j: Int, index: Int): Boolean {
    if (i !in board.indices || j !in board[i].indices || map[i][j] || board[i][j] != word[index]) {
        return false
    }
    if (index == word.lastIndex) {
        return true
    }
    map[i][j] = true
//    println("******************")
//    map.forEach { arr ->
//        println(arr.map { if (it) "1" else "_" }.joinToString("") { s -> s })
//    }
//    println("******************")
    val res = dfs(board, map, word, i + 1, j, index + 1)
            || dfs(board, map, word, i - 1, j, index + 1)
            || dfs(board, map, word, i, j + 1, index + 1)
            || dfs(board, map, word, i, j - 1, index + 1)
    map[i][j] = false
    return res
}


fun main() {
    println(
        exist(
            arrayOf(
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray()
            ), "ABCCED"
        )
    )
    println(
        exist(
            arrayOf(
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray()
            ), "SEE"
        )
    )
    println(
        exist(
            arrayOf(
                "ABCE".toCharArray(),
                "SFCS".toCharArray(),
                "ADEE".toCharArray()
            ), "ABCB"
        )
    )
}