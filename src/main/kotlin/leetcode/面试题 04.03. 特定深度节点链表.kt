package leetcode

import java.util.*

/*
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]

 */
private fun listOfDepth(tree: TreeNode?): Array<ListNode?> {
    val res = ArrayList<ListNode?>()
    if (tree == null) {
        return emptyArray()
    }
    val queue = LinkedList<TreeNode>().also { it.offer(tree) }
    while (queue.isNotEmpty()) {
        val size = queue.size
        val head = ListNode(0)
        var temp: ListNode? = head
        for (i in 1..size) {
            val node = queue.pop()
            temp!!.next = ListNode(node.`val`)
            temp = temp.next
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
        }
        res.add(head.next)
    }
    return res.toTypedArray()
}

fun main() {
    println(listOfDepth(TreeNode(1, 2, 3, 4, 5, null, 7, 8)).contentToString())
}