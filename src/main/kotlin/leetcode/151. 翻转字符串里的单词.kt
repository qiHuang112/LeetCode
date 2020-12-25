package leetcode

import java.lang.StringBuilder

/*
给定一个字符串，逐个翻转字符串中的每个单词。
说明：
无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

示例 1：
输入："the sky is blue"
输出："blue is sky the"

示例 2：
输入："  hello world!  "
输出："world! hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。

示例 3：
输入："a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

示例 4：
输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"

示例 5：
输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"
 
提示：
1 <= s.length <= 104
s 包含英文大小写字母、数字和空格 ' '
s 中 至少存在一个 单词
 
进阶：
请尝试使用 O(1) 额外空间复杂度的原地解法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun reverseWords(s: String): String {
    val res = StringBuilder()
    var (left, right) = 0 to s.lastIndex
    while (left <= right && s[left] == ' ') {
        left++
    }
    while (left <= right && s[right] == ' ') {
        right--
    }
    while (left <= right) {
        if (res.isNotEmpty()) {
            res.insert(0, ' ')
        }
        val start = left
        var end = start
        while (end <= right && s[end] != ' ') {
            end++
        }
        for (i in end - 1 downTo start) {
            res.insert(0, s[i])
        }
        while (end <= right && s[end] == ' ') {
            end++
        }
        left = end
    }
    return res.toString()
}

fun main() {
    println(reverseWords("the sky is blue"))
    println(reverseWords("  hello world!  "))
    println(reverseWords("a good   example"))
    println(reverseWords("  Bob    Loves  Alice   "))
    println(reverseWords("Alice does not even like bob"))
}