package leetcode

import java.lang.StringBuilder
import java.util.*

/*
无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。

示例1:
 输入：S = "qwe"
 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]

示例2:
 输入：S = "ab"
 输出：["ab", "ba"]

提示:
字符都是英文字母。
字符串长度在[1, 9]之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-i-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 三种思路：
 * 1.dfs，每次选可选的字符，然后回溯，n*n-1*...*1
 * 2.bfs，规模n转化为规模n-1的问题，然后插入 -> f(n) = n * f(n-1)
 * 3.队列，插入排列，中间过程保存在队列中
 */

/**
 * 思路1：dfs
 */
private fun permutation1(S: String): Array<String> {
    val res = mutableListOf<String>()
    val temp = CharArray(S.length)
    val map = BooleanArray(S.length)
    fun dfs(index: Int) {
        if (index == S.length) {
            res.add(String(temp))
            return
        }
        for (i in S.indices) {
            if (!map[i]) {
                temp[index] = S[i]
                map[i] = true
                dfs(index + 1)
                map[i] = false
            }
        }
    }
    dfs(0)
    return res.toTypedArray()
}

/**
 * 思路2：bfs
 */
private fun permutation2(S: String): Array<String> {
    if (S.length == 1) return arrayOf(S)
    val last = permutation2(S.substring(1))
    val res = mutableListOf<String>()
    for (i in 0..S.lastIndex) {
        for (s in last) {
            res.add(StringBuilder(s).insert(i, S[0]).toString())
        }
    }
    return res.toTypedArray()
}

/**
 * 思路3:队列
 */
private fun permutation(S: String): Array<String> {
    val queue = LinkedList<StringBuilder>()
    var index = 1
    queue.addLast(StringBuilder().append(S[0]))
    while (index < S.length) {
        val size = queue.size
        for (i in 1..size) {
            queue.removeFirst().apply {
                for (j in 0..this.length) {
                    StringBuilder(this).insert(j, S[index]).let(queue::addLast)
                }
            }
        }
        index++
    }
    return Array(queue.size) { queue[it].toString() }
}

fun main() {
//    println(permutation("qwe").contentToString())
//    println(permutation("ab").contentToString())
    println(permutation("hzxEfXdb").contentToString())
}