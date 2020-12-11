package leetcode

/*
给定一个单词，你需要判断单词的大写使用是否正确。
我们定义，在以下情况时，单词的大写用法是正确的：

全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
否则，我们定义这个单词没有正确使用大写字母。

示例 1:
输入: "USA"
输出: True

示例 2:
输入: "FlaG"
输出: False
注意: 输入是由大写和小写拉丁字母组成的非空单词。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/detect-capital
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 条件:
 * 1.全大写
 * 2.全小写
 * 3.首字母大写
 *
 * 简化：
 * 1.首字母大写 -> 剩余字母全小写或全大写
 * 2.首字母小写 -> 剩余字母全小写
 */
private fun detectCapitalUse(word: String): Boolean {
    if (word[0].isUpperCase()) {
        return word.substring(1).let { it.all(Char::isUpperCase) || it.all(Char::isLowerCase) }
    }
    return word.substring(1).all(Char::isLowerCase)
}

fun main() {
    println(detectCapitalUse("USA"))
    println(detectCapitalUse("FlaG"))
    println(detectCapitalUse("flag"))
    println(detectCapitalUse("flAg"))
}