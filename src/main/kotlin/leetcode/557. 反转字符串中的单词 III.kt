package leetcode

/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：
在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 调库不讲武德
 */
private fun reverseWords1(s: String): String {
    return s.split(" ").map(CharSequence::reversed).joinToString(" ") { it }
}

/**
 * 自己实现一个吧
 */
private fun reverseWords(s: String): String {
    val swap = { arr: CharArray, start: Int, end: Int ->
        for (i in 0..(end - start) / 2) {
            val temp = arr[i + start]
            arr[i + start] = arr[end - i]
            arr[end - i] = temp
        }
    }
    val res = s.toCharArray()
    var (start, end) = 0 to 0
    while (end < res.size) {
        start = end
        while (end < res.size && res[end] != ' ') {
            end++
        }
        swap(res, start, end - 1)
        end++
    }
    return String(res)
}

fun main() {
    println(reverseWords("Let's take LeetCode contest"))
}