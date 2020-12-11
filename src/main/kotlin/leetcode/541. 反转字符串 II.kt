package leetcode

import java.lang.StringBuilder

/*
给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 
示例:
输入: s = "abcdefg", k = 2
输出: "bacdfeg"
 
提示：
该字符串只包含小写英文字母。
给定字符串的长度和 k 在 [1, 10000] 范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-string-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 调库不讲武德
 */
private fun reverseStr1(s: String, k: Int): String {
    val res = StringBuilder()
    var flag = true
    for (i in 0 until s.length / k) {
        res.append(s.substring(i * k, i * k + k).let { if (flag) it.reversed() else it })
        flag = !flag
    }
    return res.append(s.subSequence(s.length / k * k, s.length).let { if (flag) it.reversed() else it }).toString()
}

/**
 * 老实自己实现
 */
private fun reverseStr(s: String, k: Int): String {
    val swap = { arr: CharArray, left: Int, right: Int ->
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
    }
    val res = s.toCharArray()
    var (flag, index) = true to 0
    // 除得尽的
    while (index + k - 1 < s.lastIndex) {
        if (flag) {
            // index ~ index + k - 1这k个数反转
            var (left, right) = index to index + k - 1
            while (left < right) {
                swap(res, left++, right--)
            }
        }
        flag = !flag
        index += k
    }
    // 除不尽的
    if (flag) {
        var (left, right) = index to res.lastIndex
        while (left < right) {
            swap(res, left++, right--)
        }
    }
    return String(res)
}


fun main() {
    println(reverseStr(s = "abcdefg", k = 2))
    println(reverseStr(s = "", k = 2))
    println(reverseStr(s = "aaabbbc", k = 4))
    println(reverseStr(s = "abcdefg", k = 8))
    println(reverseStr(s = "abcd", k = 2))

}