package leetcode

/*
给你一个字符串 date ，它的格式为 Day Month Year ，其中：

Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
Year 的范围在 ​[1900, 2100] 之间。
请你将字符串转变为 YYYY-MM-DD 的格式，其中：

YYYY 表示 4 位的年份。
MM 表示 2 位的月份。
DD 表示 2 位的天数。
 

示例 1：

输入：date = "20th Oct 2052"
输出："2052-10-20"
示例 2：

输入：date = "6th Jun 1933"
输出："1933-06-06"
示例 3：

输入：date = "26th May 1960"
输出："1960-05-26"
 */
private fun reformatDate(date: String): String {
    val arrDay = Array(31) {
        val suffix = when (it + 1) {
            1, 21, 31 -> "st"
            2, 22 -> "nd"
            3, 23 -> "rd"
            else -> "th"
        }
        "${it + 1}$suffix"
    }
    val arrMonth = arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    var (day, month, year) = date.split(" ")
    day = String.format("%02d", arrDay.indexOf(day) + 1)
    month = String.format("%02d", arrMonth.indexOf(month) + 1)
    return "$year-$month-$day"
}

fun main() {
    println(reformatDate("20th Oct 2052"))
    println(reformatDate("6th Jun 1933"))
    println(reformatDate("26th May 1960"))
    println(reformatDate("12th Jan 2018"))
}