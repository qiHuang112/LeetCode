package leetcode

/*
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

示例 1:
输入: "A"
输出: 1

示例 2:
输入: "AB"
输出: 28

示例 3:
输入: "ZY"
输出: 701

致谢：
特别感谢 @ts 添加此问题并创建所有测试用例。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun titleToNumber(s: String): Int {
    var res = 0
    for (c in s) {
        res *= 26
        res += c - 'A' + 1
    }
    return res
}

private fun convertToTitle(n: Int): String {
    if (n <= 26) return "${'A' + n - 1}"
    return convertToTitle((n - 1) / 26) + convertToTitle((n - 1) % 26 + 1)
}

fun main() {
    for (i in 1..701) {
        val title = convertToTitle(i)
        println("$i -> $title -> ${titleToNumber(title)}")
    }
}