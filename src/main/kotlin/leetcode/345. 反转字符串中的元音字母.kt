package leetcode

/*
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1：
输入："hello"
输出："holle"

示例 2：
输入："leetcode"
输出："leotcede"

提示：
元音字母不包含字母 "y" 。
 */
private fun reverseVowels(s: String): String {
    val arr = s.toCharArray()
    var (left, right) = 0 to arr.lastIndex
    while (left < right) {
        while (left < right && arr[left] !in "aeiouAEIOU") {
            left++
        }
        while (left < right && arr[right] !in "aeiouAEIOU") {
            right--
        }
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }
    return String(arr)
}

fun main() {
    println(reverseVowels("hello"))
    println(reverseVowels("leetcode"))
}