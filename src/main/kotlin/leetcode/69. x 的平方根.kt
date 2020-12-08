package leetcode

/*
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1.累加法
 */
private fun mySqrt1(x: Int): Int {
    var res = 0
    var cur = 1
    var sum = 1L
    while (sum <= x) {
        cur += 2
        sum += cur
        res += 1
    }
    return res
}

/**
 * 2.二分法
 * 值在区间[left, right) 且 left + 1 == right时，返回left
 */
private fun mySqrt2(x: Int): Int {
    var (left, right) = 0L to x.toLong() + 1
    while (left <= right - 1) {
        val mid = (right - left) / 2 + left
        val product = mid * mid
        if (product > x) {
            right = mid
        } else if (product < x) {
            left = mid + 1
        } else {
            return mid.toInt()
        }
    }
    return right.toInt() - 1
}

/**
 * 别人的二分法
 */
private fun mySqrt3(x: Int): Int {
    var (left, right) = 1 to x
    while (left <= right) {
        val mid = (left + right) / 2
        val s = x / mid
        if (s == mid) {
            return mid
        }
        if (s < mid) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return right
}

/**
 * 牛顿迭代法
 */
private fun mySqrt(x: Int): Int {
    if (x == 0) return 0
    var r = x
    while (r > x / r) {
        r = (r - x / r) / 2 + x / r
    }
    return r
}


fun main() {
    for (i in 0..100) {
        println("i:$i, sqrt:${mySqrt(i)}")
    }
}


