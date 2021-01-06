package leetcode

/*
给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
一个点的坐标（x，y）由一个有两个整数的整数数组表示。

示例:
输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
输出: True

注意:
所有输入整数都在 [-10000，10000] 范围内。
一个有效的正方形有四个等长的正长和四个等角（90度角）。
输入点没有顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 四边相等&&存在一个角为直角
 * 有点恶心
 */
private fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
    fun distance(line: Pair<IntArray, IntArray>): Int {
        val (a, b) = line
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1])
    }

    val arr = arrayOf(
        distance(p1 to p2),
        distance(p2 to p3),
        distance(p3 to p4),
        distance(p4 to p1),
        distance(p1 to p3),
        distance(p4 to p2),
    )
    arr.sort()
    return !(arr[0] == 0 || arr[1] != arr[0] || arr[2] != arr[0] || arr[3] != arr[0] || arr[4] != arr[0] * 2 || arr[5] != arr[0] * 2)
}

fun main() {
    println(validSquare(p1 = intArrayOf(0, 0), p2 = intArrayOf(1, 1), p3 = intArrayOf(1, 0), p4 = intArrayOf(0, 1)))
    println(validSquare(p1 = intArrayOf(1, 1), p2 = intArrayOf(3, 5), p3 = intArrayOf(5, 3), p4 = intArrayOf(7, 7)))
    println(validSquare(p1 = intArrayOf(1, 0), p2 = intArrayOf(0, 1), p3 = intArrayOf(0, -1), p4 = intArrayOf(-1, 0)))
    println(validSquare(p1 = intArrayOf(0, 0), p2 = intArrayOf(1, 1), p3 = intArrayOf(0, 0), p4 = intArrayOf(1, 1)))
}