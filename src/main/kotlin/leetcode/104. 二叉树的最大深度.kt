package leetcode

import java.util.*

/*
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 递归
 */
private fun maxDepth1(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + maxOf(maxDepth1(root.left), maxDepth1(root.right))
}

/**
 * 迭代
 */
private fun maxDepth(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    var res = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.pop()
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
        res++
    }
    return res
}


fun main() {
    println(maxDepth(TreeNode(3, 9, 20, null, null, 15, 7)))
}