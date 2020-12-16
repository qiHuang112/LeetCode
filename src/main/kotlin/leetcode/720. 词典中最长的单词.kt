package leetcode

/*
给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
若无答案，则返回空字符串。

示例 1：
输入：
words = ["w","wo","wor","worl", "world"]
输出："world"
解释：
单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。

示例 2：
输入：
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释：
"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。

提示：
所有输入的字符串都只包含小写字母。
words数组长度范围为[1,1000]。
words[i]的长度范围为[1,30]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 哈希表
 */
private fun longestWord(words: Array<String>): String {
    val set = mutableSetOf<String>()
    for (word in words) {
        set.add(word)
    }
    val res = mutableSetOf<String>()
    for (s in set) {
        helper(s, set, res)
    }
    if (res.isEmpty()) return ""
    return res.fold(mutableListOf<String>()) { acc, s ->
        if (acc.isEmpty()) {
            acc.add(s)
        } else {
            if (acc.first().length < s.length) {
                acc.clear()
                acc.add(s)
            } else if (acc.first().length == s.length) {
                acc.add(s)
            }
        }
        acc
    }.reduce(::minOf)
}

/**
 * 将所有满足条件的String加入res
 */
private fun helper(s: String, set: MutableSet<String>, res: MutableSet<String>): Boolean {
    if (res.contains(s)) return true
    if (!set.contains(s)) return false
    val sub = s.substring(0, s.lastIndex)
    val bool = s.length == 1 || res.contains(sub) || helper(sub, set, res)
    if (bool) {
        res.add(s)
    }
    return bool
}

fun main() {
    println(longestWord(arrayOf("w", "wo", "wor", "worl", "world")))
    println(longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple")))
}