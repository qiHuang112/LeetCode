package leetcode

/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:
输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isPalindrome(s: String): Boolean {
    var (left, right) = 0 to s.lastIndex
    while (left < right) {
        while (left < right && !s[left].isLetterOrDigit()) {
            left++
        }
        while (left < right && !s[right].isLetterOrDigit()) {
            right--
        }
        if (left == right) {
            return true
        }
        if (s[left].toLowerCase() != s[right].toLowerCase()) {
            return false
        }
        left++
        right--
    }
    return true
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
}