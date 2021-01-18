package leetcode

import java.lang.StringBuilder

/*
编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
注意：本题相对原题稍作修改

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    fun format(s: String): StringBuilder {
        val d = s.fold(IntArray(26)) { acc, c -> acc.also { it[c - 'a']++ } }
        return d.foldIndexed(StringBuilder()) { index, acc, i -> acc.apply { if (i > 0) append('a' + index).append(i) } }
    }

    val map = mutableMapOf<String, Int>()
    val res = mutableListOf<MutableList<String>>()
    var index = 0
    for (str in strs) {
        val formatted = format(str).toString()
        if (map.containsKey(formatted)) {
            res[map[formatted]!!].add(str)
        } else {
            map[formatted] = index++
            res.add(mutableListOf(str))
        }
    }
    return res
}

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}