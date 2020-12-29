package leetcode

/*
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

示例 1：
输入：timePoints = ["23:59","00:00"]
输出：1

示例 2：
输入：timePoints = ["00:00","23:59","00:00"]
输出：0

提示：
2 <= timePoints <= 2 * 104
timePoints[i] 格式为 "HH:MM"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-time-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findMinDifference(timePoints: List<String>): Int {
    if(timePoints.size > 1440){
        return 0
    }
    val times = timePoints.map(::stringToMinute).sorted()
    var min = times.first() + 24 * 60 - times.last()
    for (i in 1..times.lastIndex) {
        min = minOf(times[i] - times[i - 1], min)
    }
    return min
}

private fun stringToMinute(string: String): Int {
    val (hour, minute) = string.split(":")
    return hour.toInt() * 60 + minute.toInt()
}

fun main() {
    println(findMinDifference(listOf("23:59", "00:00")))
    println(findMinDifference(listOf("00:00", "23:59", "00:00")))
}