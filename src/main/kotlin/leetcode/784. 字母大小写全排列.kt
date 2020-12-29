package leetcode

import java.util.*

/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例：
输入：S = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入：S = "3z4"
输出：["3z4", "3Z4"]

输入：S = "12345"
输出：["12345"]

提示：
S 的长度不超过12。
S 仅由数字和字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun letterCasePermutation(S: String): List<String> {
    val res = LinkedList<String>()
    // 加入哨兵
    res.addLast("")
    var index = 0
    while (index < S.length) {
        val size = res.size
        for (i in 1..size) {
            val cur = res.removeFirst()
            if (S[index].isDigit()) {
                res.addLast(cur + S[index])
            } else {
                res.addLast(cur + S[index].toLowerCase())
                res.addLast(cur + S[index].toUpperCase())
            }
        }
        index++
    }
    return res
}

fun main() {
    println(letterCasePermutation("a1b2"))
    println(letterCasePermutation("3z4"))
    println(letterCasePermutation("12345"))
}