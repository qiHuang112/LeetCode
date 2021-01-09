package leetcode

import java.util.*

/*
给定一个二叉树

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

示例：
输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。

提示：
树中的节点数小于 6000
-100 <= node.val <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Node117(var `val`: Int) {
    var left: Node117? = null
    var right: Node117? = null
    var next: Node117? = null

    constructor(v0: Int, vararg v: Int?) : this(v0) {
        val queue = LinkedList<Node117?>()
        var index = -1
        queue.offer(this)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val temp = queue.pop()
                if (temp != null) {
                    index++
                    if (index < v.size && v[index] != null) {
                        temp.left = Node117(v[index]!!)
                    }
                    index++
                    if (index < v.size && v[index] != null) {
                        temp.right = Node117(v[index]!!)
                    }
                    queue.offer(temp.left)
                    queue.offer(temp.right)
                }
            }
        }
    }
}

private fun connect(root: Node117?): Node117? {
    val queue = LinkedList<Node117>()
    root?.let(queue::offer)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.pop()
            if (i != size) {
                node.next = queue.peek()
            }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
    }
    return root
}

fun main() {
    val node = connect(Node117(1, 2, 3, 4, 5, null, 7))
    fun dfs(node: Node117?) {
        if (node == null) return
        println("${node.`val`} -> ${node.next?.`val`}")
        dfs(node.left)
        dfs(node.right)
    }
    dfs(node)
}