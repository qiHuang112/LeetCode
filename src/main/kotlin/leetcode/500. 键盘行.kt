package leetcode

/*
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
"qwertyuiop"
"asdfghjkl"
"zxcvbnm"
示例：
输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]
 
注意：
你可以重复使用键盘上同一字符。
你可以假设输入的字符串将只包含字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/keyboard-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 方法1
 */
private fun findWords1(words: Array<String>): Array<String> {
    val map = IntArray(26)
    val setFlag = { c: Char, flag: Int -> map[c.toInt() - 'a'.toInt()] = flag }
    "qwertyuiop".forEach { setFlag(it, 1) }
    "asdfghjkl".forEach { setFlag(it, 2) }
    "zxcvbnm".forEach { setFlag(it, 3) }

    val oneLine = { s: String ->
        var oneLine = true
        if (s.isNotEmpty()) {
            val flag = map[s[0].toLowerCase().toInt() - 'a'.toInt()]
            for (i in 1..s.lastIndex) {
                if (map[s[i].toLowerCase().toInt() - 'a'.toInt()] != flag) {
                    oneLine = false
                    break
                }
            }
        }
        oneLine
    }
    return words.filter(oneLine).toTypedArray()
}

/**
 * 方法2
 */
private fun findWords(words: Array<String>): Array<String> {
    val map = IntArray(26)
    listOf("qwertyuiop", "asdfghjkl", "zxcvbnm").forEachIndexed { index, s ->
        s.forEach { map[it.toInt() - 'a'.toInt()] = index + 1 }
    }
    val oneLine = { s: String ->
        var oneLine = true
        var (l1, l2, l3) = arrayOf(0, 0, 0)
        for (c in s) {
            when (map[c.toLowerCase().toInt() - 'a'.toInt()]) {
                1 -> l1++
                2 -> l2++
                3 -> l3++
            }
            if (l1 + l2 + l3 + 1 != (l1 + 1) * (l2 + 1) * (l3 + 1)) {
                oneLine = false
                break
            }
        }
        oneLine
    }
    return words.filter(oneLine).toTypedArray()
}

fun main() {
    println(findWords(arrayOf("Hello", "Alaska", "Dad", "Peace")).contentToString())
    println(findWords(arrayOf("Aasdfghjkl", "Qwertyuiop", "zZxcvbnm")).contentToString())
}