package leetcode

/*
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 滑动窗口
 */
private fun findSubstring(s: String, words: Array<String>): List<Int> {
    // 记录所有可用词的个数
    val map = mutableMapOf<String, Int>()
    for (word in words) {
        map[word] = (map[word] ?: 0) + 1
    }
    val res = mutableListOf<Int>()
    val curMap = mutableMapOf<String, Int>()
    val len = words[0].length
    var index = 0
    var flag: Boolean
    while (index < s.length - words.size * len + 1) {
        curMap.clear()
        flag = true
        println(
            "验证区间:[${index}, ${index + words.size * len}]-> [${
                s.substring(
                    index,
                    index + words.size * len
                )
            }]"
        )
        for (i in index until index + words.size * len step len) {
            val curString = s.substring(i, i + len)
            curMap[curString] = (curMap[curString] ?: 0) + 1
            if (curMap[curString]!! > (map[curString] ?: 0)) {
                flag = false
                break
            }
        }
        if (flag) res.add(index)
        index++
    }
    return res
}

fun main() {
    println(findSubstring("barfoothefoobarman", arrayOf("foo", "bar")))
    println(findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")))
    println(findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "good")))
    println(
        findSubstring(
            "lingmindraboofooowingdingbarrwingmonkeypoundcake",
            arrayOf("fooo", "barr", "wing", "ding", "wing")
        )
    )
}

/*
"lingmindraboofooowingdingbarrwingmonkeypoundcake"
["fooo","barr","wing","ding","wing"]
 */