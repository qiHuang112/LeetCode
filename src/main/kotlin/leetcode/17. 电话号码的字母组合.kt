package leetcode

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private val map = arrayOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

private fun letterCombinations(digits: String): List<String> {
    val res = mutableListOf<String>()
    if (digits.isEmpty()) return res
    dfs(digits, 0, res, CharArray(digits.length))
    return res
}

private fun dfs(digits: String, i: Int, res: MutableList<String>, temp: CharArray) {
    if (i == temp.size) {
        res.add(String(temp))
        return
    }
    for (c in map[digits[i].toInt() - '0'.toInt()]) {
        temp[i] = c
        dfs(digits, i + 1, res, temp)
    }
}

fun main() {
    println(letterCombinations("23"))
    println(letterCombinations("233"))
}