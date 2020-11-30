package leetcode

import java.util.*

/*
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

例如:
给定二叉树: [3,9,20,null,null,15,7],

返回其层次遍历结果：

[
[3],
[9,20],
[15,7]
]
 */
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    val queue = LinkedList<TreeNode>().also { it.offer(root) }
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 1..size) {
            val node = queue.pop()
            list.add(node.`val`)
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
        }
        res.add(list)
    }
    return res
}

fun main() {
    println(levelOrder(TreeNode(3, 9, 20, null, null, 15, 7)))
}