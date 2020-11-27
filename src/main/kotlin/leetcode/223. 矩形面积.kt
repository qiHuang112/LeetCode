package leetcode

import java.util.*
import kotlin.math.*

/**
在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。

示例:

输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45
 */
private fun computeArea(A: Int, B: Int, C: Int, D: Int, E: Int, F: Int, G: Int, H: Int): Int {
    // 两个矩形的面积
    val area1 = (C - A) * (D - B)
    val area2 = (G - E) * (H - F)
    var area3 = 0
    // x方向和y方向是否重叠
    val boolX = !(max(A, C) <= min(E, G) || max(E, G) <= min(A, C))
    val boolY = !(max(B, D) <= min(H, F) || max(H, F) <= min(B, D))
    if (boolX && boolY) {
        area3 = calc(A, C, E, G) * calc(D, B, H, F)
    }
    println(area1)
    println(area2)
    println(area3)
    return area1 + area2 - area3
}

/**
 * 四个数排序，并取中间两项的差值
 */
private fun calc(a: Int, b: Int, c: Int, d: Int): Int {
    val arr = intArrayOf(a, b, c, d)
    Arrays.sort(arr)
    return arr[2] - arr[1]
}

fun main() {
    println(computeArea(-3, 0, 3, 4, 0, -1, 9, 6))
}