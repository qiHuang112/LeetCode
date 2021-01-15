package leetcode

/*
括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。

说明：解集不能包含重复的子集。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bracket-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun generateParenthesis1(n: Int): List<String> {
    val res = mutableListOf<String>()
    val temp = CharArray(2 * n)
    var (left, right) = 0 to 0
    fun dfs(index: Int) {
        if (index == 2 * n) {
            res.add(String(temp))
            return
        }
        if (left > n || right > n || right > left) {
            return
        }
        if (left != n) {
            temp[index] = '('
            left++
            dfs(index + 1)
            left--
        }
        temp[index] = ')'
        right++
        dfs(index + 1)
        right--
    }
    dfs(0)
    return res
}

private fun generateParenthesis(n: Int): List<String> {
    val res = mutableListOf<String>()
    val temp = CharArray(2 * n)
    fun dfs(index: Int, left: Int, right: Int) {
        if (index == 2 * n) {
            res.add(String(temp))
            return
        }
        if (left < n) {
            temp[index] = '('
            dfs(index + 1, left + 1, right)
        }
        if (left > right) {
            temp[index] = ')'
            dfs(index + 1, left, right + 1)
        }
    }
    dfs(0, 0, 0)
    return res
}

fun main() {
    println(generateParenthesis(4))
    println(generateParenthesis(3))
    println(generateParenthesis(2))
    println(generateParenthesis(1))
}