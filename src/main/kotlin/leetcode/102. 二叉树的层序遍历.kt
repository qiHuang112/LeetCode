package leetcode

import java.util.*

/*
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    val res = mutableListOf<List<Int>>()
    while (queue.isNotEmpty()) {
        val temp = mutableListOf<Int>()
        val size = queue.size
        for (i in 1..size) {
            queue.pop().let {
                temp.add(it.`val`)
                it.left?.let(queue::offer)
                it.right?.let(queue::offer)
            }
        }
        res.add(temp)
    }
    return res
}

fun main() {
    println(levelOrder(TreeNode(3, 9, 20, null, null, 15, 7)))
}