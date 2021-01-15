package leetcode

/*
有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

示例1:
 输入：S = "qqe"
 输出：["eqq","qeq","qqe"]

示例2:
 输入：S = "ab"
 输出：["ab", "ba"]

提示:
字符都是英文字母。
字符串长度在[1, 9]之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-ii-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun permutation(S: String): Array<String> {
    val map = S.fold(IntArray(128)) { acc, c -> acc.also { it[c.toInt()]++ } }
    val res = mutableListOf<String>()
    val temp = CharArray(S.length)
    fun dfs(index: Int) {
        if (index == S.length) {
            res.add(String(temp))
            return
        }
        for ((i, v) in map.withIndex()) {
            if (v > 0) {
                temp[index] = i.toChar()
                map[i]--
                dfs(index + 1)
                map[i]++
            }
        }
    }
    dfs(0)
    return res.toTypedArray()
}

fun main() {
    permutation("qqe").contentToString().let(::println)
    permutation("ab").contentToString().let(::println)
}