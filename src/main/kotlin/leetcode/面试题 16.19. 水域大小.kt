package leetcode

/*
你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
示例：

输入：
[
  [0,2,1,0],
  [0,1,0,1],
  [1,1,0,1],
  [0,1,0,1]
]
输出： [1,2,4]
提示：

0 < len(land) <= 1000
0 < len(land[i]) <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/pond-sizes-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun pondSizes(land: Array<IntArray>): IntArray {
    val res = mutableListOf<Int>()
    for (i in land.indices) {
        for (j in land[i].indices) {
            if (land[i][j] == 0) {
                val cur = dfs(land, i, j)
                res.add(cur)
            }
        }
    }
    return res.sorted().toIntArray()
}

private fun dfs(land: Array<IntArray>, i: Int, j: Int): Int {
    if (i !in land.indices || j !in land[i].indices || land[i][j] != 0) {
        return 0
    }
    land[i][j] = 1
    return dfs(land, i + 1, j + 1) + dfs(land, i + 1, j - 1) + dfs(land, i - 1, j + 1) + dfs(land, i - 1, j - 1) +
            dfs(land, i + 1, j) + dfs(land, i - 1, j) + dfs(land, i, j + 1) + dfs(land, i, j - 1) + 1
}

fun main() {
    println(
        pondSizes(
            arrayOf(
                intArrayOf(0, 2, 1, 0),
                intArrayOf(0, 1, 0, 1),
                intArrayOf(1, 1, 0, 1),
                intArrayOf(0, 1, 0, 1),
            )
        ).contentToString()
    )
}