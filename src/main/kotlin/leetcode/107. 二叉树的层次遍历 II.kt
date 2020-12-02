package leetcode

import java.util.*

/*
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val res = LinkedList<MutableList<Int>>()
    if (root == null) return res
    val queue = LinkedList<TreeNode>().apply { offer(root) }
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = mutableListOf<Int>()
        for (i in 1..size) {
            val node = queue.pop()
            list.add(node.`val`)
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
        res.addFirst(list)
    }
    return res
}

fun main() {
    println(levelOrderBottom(TreeNode(3, 9, 20, null, null, 15, 7)))
}