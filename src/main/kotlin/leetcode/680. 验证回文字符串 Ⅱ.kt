package leetcode

/*
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:
输入: "aba"
输出: True

示例 2:
输入: "abca"
输出: True
解释: 你可以删除c字符。

注意:
字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

private fun validPalindrome(s: String): Boolean {
    return validPalindrome(s.toCharArray(), 0, s.lastIndex)
}

private fun validPalindrome(arr: CharArray, start: Int, end: Int): Boolean {
    return isPalindrome(arr, start + 1, end) || isPalindrome(arr, start, end - 1)
            || (arr[start] == arr[end] && validPalindrome(arr, start + 1, end - 1))
}

private fun isPalindrome(arr: CharArray, start: Int, end: Int): Boolean {
    var (left, right) = start to end
    while (left <= right) {
        if (arr[left++] != arr[right--]) {
            return false
        }
    }
    return true
}

fun main() {
    println(validPalindrome("aba"))
    println(validPalindrome("abca"))
    println(validPalindrome("abcbaa"))
    println(validPalindrome("abcbadda"))

}