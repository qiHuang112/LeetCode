package leetcode

/*
有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：
装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空

示例 1: (From the famous "Die Hard" example)
输入: x = 3, y = 5, z = 4
输出: True

示例 2:
输入: x = 2, y = 6, z = 5
输出: False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/water-and-jug-problem
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
    // 1. 确保x<=y
    if (x > y) return canMeasureWater(y, x, z)
    // 2. 求x,y的公约数n，所有可能的值在 (0..x+y step n)中
    val n = getCommonDivisor(x, y)
    if (n == 0) return z == 0
    return z <= x + y && z % n == 0
}

private fun getCommonDivisor(x: Int, y: Int): Int {
    if (x == 0) return y
    return getCommonDivisor(y % x, x)
}

fun main() {
    println(canMeasureWater(x = 3, y = 5, z = 4))
    println(canMeasureWater(x = 2, y = 6, z = 5))
    println(canMeasureWater(x = 0, y = 0, z = 0))
}
/*
3,5
0 1 2 3 4 5 6 7 8
2,6
0 2 4 6 8
4,5
0 1 2 3 4 5 6 7 8 9
4,6
0 2 4 6 8 10
7,10
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
4,8
0 4 8 12
4,12
0 4 8 12 16
3,9
0 3 6 9 12
6,9
0 3 6 9 12 15
 */