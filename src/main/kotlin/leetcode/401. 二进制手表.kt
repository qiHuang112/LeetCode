package leetcode

/*
二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。

8 4 (2) (1)
32 (16) (8) 4 2 (1)

例如，上面的二进制手表读取 “3:25”。
给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

示例：
输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

提示：
输出的顺序没有要求。
小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-watch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * 1.根据给定的1的个数计算所有可能的hours
 * 2.根据给定的1的个数计算所有可能的minutes
 * 3.组合
 */
private fun readBinaryWatch1(num: Int): List<String> {
    val res = mutableListOf<String>()
    for (i in 0..num) {
        val hours = getTimes(4, i, 11)
        val minutes = getTimes(6, num - i, 59)
        for (hour in hours) {
            for (minute in minutes) {
                res.add("$hour:%02d".format(minute))
            }
        }
    }
    return res
}

/**
 * 字典序组合 C(n,k)
 * 返回所有满足条件的时间
 */
private fun getTimes(n: Int, k: Int, limit: Int): List<Int> {
    val res = mutableListOf<Int>()
    if (k == 0) return listOf(0)
    var temp = 1.shl(k) - 1
    val max = temp.shl(n - k)
    while (temp <= max) {
        if (temp <= limit) {
            res.add(temp)
        }
        // 末尾有t个连续的0  t个连续0之前有m个连续的1，t允许为0，m一定大于等于1
        val (t, m) = count01(temp)
        // 根据t, m求出字典序的下一个数
        temp += 1.shl(m - 1) + 1.shl(t) - 1
    }
    return res
}

/**
 * 计算末尾0和1的个数
 * 0b1100 -> return 2,2
 * 0b0110 -> return 1,2
 * 0b0111 -> return 0,3
 */
private fun count01(n: Int): Pair<Int, Int> {
    var t = 0
    var m = 0
    var temp1 = n
    while (temp1.and(1) == 0) {
        temp1 = temp1.shr(1)
        t++
    }
    while (temp1.and(1) == 1) {
        temp1 = temp1.shr(1)
        m++
    }
    return t to m
}

/**
 * 思路：
 * 1.将所有时间的1的个数记录下来
 * 2.根据总共的个数num,筛选出满足条件的值
 */
private fun readBinaryWatch(num: Int): List<String> {
    val bitCount = IntArray(60, Integer::bitCount)
    val res = mutableListOf<String>()
    for (hour in 0..11) {
        if (num >= bitCount[hour]) {
            for (minute in 0..59) {
                if (bitCount[minute] + bitCount[hour] == num) {
                    res.add("$hour:%02d".format(minute))
                }
            }
        }
    }
    return res
}

fun main() {
    println(readBinaryWatch(1))
    println(readBinaryWatch(2))
    println(readBinaryWatch(3))
    println(readBinaryWatch(10))
}