package leetcode

import java.util.*

/*
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
 */
private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    val queue = LinkedList<TreeNode>().apply { offer(root) }
    var reverse = false
    while (queue.isNotEmpty()) {
        val index = queue.size
        val list = mutableListOf<Int>()
        for (i in 1..index) {
            val node = queue.pop()
            list.add(node.`val`)
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
        }
        if (reverse) {
            res.add(list.asReversed())
        } else {
            res.add(list)
        }
        reverse = !reverse
    }
    return res
}

fun main() {
    println(zigzagLevelOrder(TreeNode(3, 9, 20, null, null, 15, 7)))
}