package leetcode

/*
根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。

示例：

输入：
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
输出：
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

进阶：

你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/game-of-life
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 条件：8个格子1的个数
 * 0..1  0 -> 0  1 -> 0
 * 2..2  0 -> 0  1 -> 1
 * 3..3  0 -> 1  1 -> 1
 * 4..8  0 -> 0  1 -> 0
 *
 * 总结：2个就是不变，3个就是1，其他的就是0
 *
 * 如何使用原地算法：
 * 分析：数字只有0,1两种，可以将下一次转换保存在高一位的二进制位上
 * 改完后，在将所有数都右移一位
 */
private fun gameOfLife(board: Array<IntArray>): Unit {
    val safeGet = { i: Int, j: Int -> if (i !in board.indices || j !in board[i].indices) 0 else board[i][j].and(1) }
    for (i in board.indices) {
        for (j in board[i].indices) {
            val count = safeGet(i - 1, j - 1) + safeGet(i - 1, j) + safeGet(i - 1, j + 1) +
                    safeGet(i, j - 1) + safeGet(i, j + 1) +
                    safeGet(i + 1, j - 1) + safeGet(i + 1, j) + safeGet(i + 1, j + 1)
            when (count) {
                2 -> board[i][j] += board[i][j] * 2
                3 -> board[i][j] += 2
            }
        }
    }
    for (i in board.indices) {
        for (j in board[i].indices) {
            board[i][j] = board[i][j].shr(1)
        }
    }
}

fun main() {
    arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(0, 0, 0),
    ).apply(::gameOfLife).map(IntArray::contentToString).forEach(::println)
}