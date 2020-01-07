package leetcode

import java.util.*

class ListNode(val `val`: Int) {
    var next: ListNode? = null
    override fun toString() = "$`val` -> $next"

    constructor(v0: Int, vararg v: Int) : this(v0, v, 0)

    constructor(v0: Int, v: IntArray, index: Int) : this(v0) {
        if (index < v.size) {
            next = ListNode(v[index], v, index + 1)
        }
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
}