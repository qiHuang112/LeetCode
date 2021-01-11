package leetcode

/*
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例 1：
输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]

示例 2：
输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]

提示：
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] 是一个小写英文字母
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] 由小写英文字母组成
words 中的所有字符串互不相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    fun search(word: String): Boolean {
        val map = Array(board.size) { BooleanArray(board[0].size) }
        fun dfs(index: Int, i: Int, j: Int): Boolean {
            if (index == word.length) return true
            if (i !in board.indices || j !in board[i].indices || map[i][j] || board[i][j] != word[index]) {
                return false
            }
            map[i][j] = true
            val res = dfs(index + 1, i + 1, j) || dfs(index + 1, i, j + 1)
                    || dfs(index + 1, i - 1, j) || dfs(index + 1, i, j - 1)
            map[i][j] = false
            return res
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (word[0] == board[i][j]) {
                    if (dfs(0, i, j)) return true
                }
            }
        }
        return false
    }
    return words.filter(::search)
}

fun main() {
    println(
        findWords(
            arrayOf(
                "oaan".toCharArray(),
                "etae".toCharArray(),
                "ihkr".toCharArray(),
                "iflv".toCharArray(),
            ), arrayOf("oath", "pea", "eat", "rain")
        )
    )
}