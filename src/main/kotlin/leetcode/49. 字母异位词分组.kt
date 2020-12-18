package leetcode

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
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
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 思路：
 * hash + 覆写 equals 和 hashCode 方法
 */
private class MyString(val str: String) {
    override fun equals(other: Any?): Boolean {
        // 地址相等
        if (this === other) return true
        // 类型相同
        if (other !is MyString) return false
        // 内涵相同
        val map1 = str.fold(IntArray(26)) { acc, c ->
            acc[c.toInt() - 'a'.toInt()]++
            acc
        }
        val map2 = other.str.fold(IntArray(26)) { acc, c ->
            acc[c.toInt() - 'a'.toInt()]++
            acc
        }
        return map1.contentEquals(map2)
    }

    override fun hashCode(): Int {
        return str.fold(0) { acc, c -> acc + c.toInt() }
    }
}

private fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    val map = strs.map(::MyString).groupBy { it }
    return map.keys.fold(mutableListOf()) { acc, myString ->
        acc.add(map[myString]!!.map { it.str })
        acc
    }
}

/**
 * 暴力
 */
private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    return strs.fold(mutableMapOf<String, MutableList<String>>()) { acc, s ->
        val curString = s.toCharArray().sorted().toString()
        acc[curString] = (acc[curString] ?: mutableListOf()).apply { add(s) }
        acc
    }.values.toList()
}

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}