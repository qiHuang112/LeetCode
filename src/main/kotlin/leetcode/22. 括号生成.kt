package leetcode

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例：
输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 核心：在dfs的时候保证左括号的个数大于等于右括号的个数就好
 */
private fun generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()
    dfs(res, 0, 0, 0, CharArray(2 * n))
    return res
}

private fun dfs(res: MutableList<String>, left: Int, right: Int, i: Int, temp: CharArray) {
    if (i == temp.size) {
        res.add(String(temp))
        return
    }
    if (left > right && right < temp.size / 2) {
        temp[i] = ')'
        dfs(res, left, right + 1, i + 1, temp)
    }
    if (left < temp.size / 2) {
        temp[i] = '('
        dfs(res, left + 1, right, i + 1, temp)
    }
}

fun main() {
    println(generateParenthesis(3))
}