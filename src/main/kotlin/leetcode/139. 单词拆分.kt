package leetcode

/*
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-break
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力递归 -- 超时了
 */
private fun wordBreak1(s: String, wordDict: List<String>): Boolean {
    val set = wordDict.toHashSet()
    fun getRes(ss: String): Boolean {
        if (ss == "") return true
        for (i in 1..ss.length) {
            if (set.contains(ss.substring(0, i)) && getRes(ss.substring(i))) {
                return true
            }
        }
        return false
    }
    return getRes(s)
}

/**
 * 动态规划
 * 设dp[i] 为 s.subString(0,i)是否满足条件，则有
 * dp[i] = j从0~i 存在 一个j 满足 dp[j] && s.subString(j,i) in set
 */
private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val set = wordDict.toHashSet()
    val dp = BooleanArray(s.length + 1)
    dp[0] = true
    for (i in 1..s.length) {
        dp[i] = (0 until i).any { dp[it] && s.substring(it, i) in set }
    }
    return dp[s.length]
}

fun main() {
    println(wordBreak("leetcode", listOf("leet", "code")))
    println(wordBreak("applepenapple", listOf("apple", "pen")))
    println(wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
}