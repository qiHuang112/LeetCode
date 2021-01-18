package leetcode

/*
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:
s = "abaccdeff"
返回 "b"

s = ""
返回 " "

限制：
0 <= s 的长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun firstUniqChar(s: String): Char {
    val map = s.fold(IntArray(26)) { acc, c -> acc.also { it[c - 'a']++ } }
    for (c in s) {
        if (map[c - 'a'] == 1) return c
    }
    return ' '
}

fun main() {
    println(firstUniqChar("abaccdeff"))
    println(firstUniqChar(""))
}