package leetcode

/*
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
实现词典类 WordDictionary ：
WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。

示例：

输入：
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
输出：
[null,null,null,null,false,true,true,true]

解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 
提示：
1 <= word.length <= 500
addWord 中的 word 由小写英文字母组成
search 中的 word 由 '.' 或小写英文字母组成
最调用多 50000 次 addWord 和 search

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class WordDictionary() {

    var children = Array<WordDictionary?>(26) { null }
    var isEnd = false

    fun addWord(word: String) {
        var temp = this
        for (c in word) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = WordDictionary()
            }
            temp = temp.children[c - 'a']!!
        }
        temp.isEnd = true
    }

    fun search(word: String, index: Int = 0): Boolean {
        if (index == word.length - 1) {
            if (word[index] == '.') {
                return children.any { it?.isEnd == true }
            }
            return children[word[index] - 'a']?.isEnd == true
        }
        if (word[index] == '.') {
            for (child in children) {
                if (child?.search(word, index + 1) == true) return true
            }
            return false
        }
        return children[word[index] - 'a']?.search(word, index + 1) ?: false
    }
}

fun main() {
    WordDictionary().apply {
        addWord("bad")
        addWord("dad")
        addWord("mad")
        search("pad").let(::println)
        search("bad").let(::println)
        search(".ad").let(::println)
        search("b..").let(::println)
    }
    WordDictionary().apply {
        addWord("at")
        addWord("and")
        addWord("an")
        addWord("add")
        search("a").let(::println) // true -> false
        search(".at").let(::println) // false
        addWord("bat")
        search(".at").let(::println) // true
        search("an.").let(::println) // true
        search("a.d.").let(::println) // false
        search("b.").let(::println) // true -> false
        search("a.d").let(::println) // true
        search(".").let(::println) // true -> false
    }
}