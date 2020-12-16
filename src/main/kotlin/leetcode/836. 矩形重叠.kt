package leetcode

/*
矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。

示例 1：
输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
输出：true

示例 2：
输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
输出：false

示例 3：
输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
输出：false
 
提示：
rect1.length == 4
rect2.length == 4
-10^9 <= rec1[i], rec2[i] <= 10^9
rec1[0] <= rec1[2] 且 rec1[1] <= rec1[3]
rec2[0] <= rec2[2] 且 rec2[1] <= rec2[3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rectangle-overlap
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 如果重合 则有
 * 1.横向 两矩形中心点之间的横向距离 < 0.5(宽1 + 宽2)
 * 2.纵向 两矩形中心点之间的纵向距离 < 0.5(高1 + 高2)
 */
private fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    val center1 = (rec1[0].toLong() + rec1[2]) to (rec1[1].toLong() + rec1[3])
    val center2 = (rec2[0].toLong() + rec2[2]) to (rec2[1].toLong() + rec2[3])
    val wh1 = rec1[2].toLong() - rec1[0] to rec1[3].toLong() - rec1[1]
    val wh2 = rec2[2].toLong() - rec2[0] to rec2[3].toLong() - rec2[1]
    if (wh1.first == 0L || wh1.second == 0L || wh2.first == 0L || wh2.second == 0L) return false
    return (center1.first - center2.first).let(Math::abs) < wh1.first + wh2.first
            && (center1.second - center2.second).let(Math::abs) < wh1.second + wh2.second
}

fun main() {
//    println(isRectangleOverlap(intArrayOf(0, 0, 2, 2), intArrayOf(1, 1, 3, 3)))
//    println(isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 2, 1)))
//    println(isRectangleOverlap(intArrayOf(0, 0, 1, 1), intArrayOf(2, 2, 3, 3)))
    println(isRectangleOverlap(intArrayOf(-1, 0, 1, 1), intArrayOf(0, -1, 0, 1)))
//    println(isRectangleOverlap(intArrayOf(4, 0, 6, 6), intArrayOf(-5, -3, 4, 2)))
//    println(
//        isRectangleOverlap(
//            intArrayOf(-257926405, -680763313, 702840196, 454409669),
//            intArrayOf(-275916328, -417802221, 22808107, 675629469)
//        )
//    )
}