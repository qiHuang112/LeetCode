package leetcode

import java.lang.StringBuilder
import java.util.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString() = "$`val` -> $next"

    constructor(v0: Int, vararg v: Int) : this(v0, v, 0)

    constructor(v0: Int, v: IntArray, index: Int) : this(v0) {
        if (index < v.size) {
            next = ListNode(v[index], v, index + 1)
        }
    }

    constructor(range: Iterable<Int>) : this(range.first()) {
        val it = range.iterator()
        it.next()
        var temp = this
        while (it.hasNext()) {
            temp.next = ListNode(it.next())
            temp = temp.next!!
        }
    }

    fun append(node: ListNode?): ListNode {
        var temp = this
        while (temp.next != null) {
            temp = temp.next!!
        }
        temp.next = node
        return this
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(v0: Int, vararg v: Int?) : this(v0) {
        val queue = LinkedList<TreeNode?>()
        var index = -1
        queue.offer(this)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val temp = queue.pop()
                if (temp != null) {
                    index++
                    if (index < v.size && v[index] != null) {
                        temp.left = TreeNode(v[index]!!)
                    }
                    index++
                    if (index < v.size && v[index] != null) {
                        temp.right = TreeNode(v[index]!!)
                    }
                    queue.offer(temp.left)
                    queue.offer(temp.right)
                }
            }
        }
    }

    // 层序遍历，并保存在一个数组中，并删除尾部多余null
    private fun toArray(): List<Int?> {
        val arr = ArrayList<Int?>()
        val queue = LinkedList<TreeNode?>()
        queue.offer(this)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val temp = queue.pop()
                arr.add(temp?.`val`)
                if (temp != null) {
                    queue.offer(temp.left)
                    queue.offer(temp.right)
                }
            }
        }
        while (arr.last() == null) {
            arr.removeAt(arr.lastIndex)
        }
        return arr
    }

    override fun toString() = toArray().toString()

    private fun getHigh(): Int =
        1 + (this.left?.getHigh() ?: 0).coerceAtLeast(this.right?.getHigh() ?: 0)

    private fun Int.charWidth(radix: Int = 10): Int = this.toString(radix).length

    private fun getValWidth(): Int =
        maxOf(this.`val`.charWidth(), this.left?.getValWidth() ?: 0, this.right?.getValWidth() ?: 0)

    private fun String.paddingTo(w: Int, c: Char = ' '): String {
        val target = if (w % 2 == 0) w + 1 else w
        if (this.length >= target) return this
        val sb = StringBuilder(this)
        while (sb.length < target) {
            sb.insert(0, c).append(c)
        }
        return sb.substring(0, target)
    }

    fun printNode(char: Char = ' ') {
        val queue = LinkedList<TreeNode?>()
        val high = getHigh()
        val width = getValWidth()
        var level = 0
        queue.offer(this)
        while (queue.any { it != null }) {
            level++
            val size = queue.size
            for (i in 0 until size) {
                val temp = queue.pop()
                val blank = " " * (((1 + width / 2)) * ((1 shl (high - level + 1)) - 1))
                val tempVal = "${temp?.`val` ?: char}".paddingTo(width)
                if (i == 0) {
                    print("$blank$tempVal")
                } else {
                    print("${blank * 2} $tempVal")
                }
                queue.offer(temp?.left)
                queue.offer(temp?.right)
            }
            println()
        }
    }

    operator fun String.times(n: Int) = (1..n).joinToString("") { this }
}

/**
 * n叉树
 */
class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}
