package leetcode

import java.lang.StringBuilder

/*
给定一个正整数，返回它在 Excel 表中相对应的列名称。
例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-title
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun convertToTitle(n: Int): String {
    if (n <= 26) return ('A'.toInt() + n - 1).toChar().toString()
    if (n % 26 == 0) return convertToTitle(n / 26 - 1) + "Z"
    return convertToTitle(n / 26) + convertToTitle(n % 26)
}


fun main() {
    println(convertToTitle(1))
    println(convertToTitle(28))
    println(convertToTitle(52))
    println(convertToTitle(701))
    println(convertToTitle(703))
}
/*
1~26 -> A~Z
28 -> 26 * 1 + 2 -> AB
52 -> 26 * 1 + 26 -> AZ
701 -> 26 * 26 + 25 -> ZY
702 -> 26 * 26 + 26 -> ZZ
703 -> 26 * 26 * 1 + 26 * 1 + 1 -> AAA

A   ~   Z       ->       1 ~ 26
AA  ~   ZZ      ->      27 ~ 26*26+26
AAA ~   ZZZ     ->     703 ~ 26*26*26+26*26+26
703 如何变成 AAA
703 % 26 = 1 A
703 / 26 = 26+1 AA
702 如何变成 ZZ
702 % 26 = 26
702 / 26 = 26+26

 */