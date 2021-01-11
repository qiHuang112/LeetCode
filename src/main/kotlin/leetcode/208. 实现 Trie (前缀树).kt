package leetcode

import java.util.*

/*
实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true

说明:
你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Trie() {
    inner class Node {
        var isEnd = false
        var children: Array<Node?> = Array(26) { null }
    }

    val head = Node()

    fun insert(word: String) {
        var temp = head
        for (c in word) {
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = Node()
            }
            temp = temp.children[c - 'a']!!
        }
        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        var temp = head
        for (c in word) {
            if (temp.children[c - 'a'] == null) {
                return false
            }
            temp = temp.children[c - 'a']!!
        }
        return temp.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var temp = head
        for (c in prefix) {
            if (temp.children[c - 'a'] == null) {
                return false
            }
            temp = temp.children[c - 'a']!!
        }
        return true
    }
}

fun main() {
    Trie().apply {
        insert("apple")
        search("apple").let(::println)
        search("app").let(::println)
        startsWith("app").let(::println)
        insert("app")
        search("app").let(::println)
    }
}