package leetcode

import kotlin.math.abs
import kotlin.math.max

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
private fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
    val left = root.left.getHigh()
    val right = root.right.getHigh()
    return left != -1 && right != -1 && isBalanced(root.left) && isBalanced(root.right) && abs(left - right) <= 1
}

private fun TreeNode?.getHigh(): Int {
    if (this == null) return 0
    val left = this.left.getHigh()
    val right = this.right.getHigh()
    if (abs(left - right) > 1) {
        return -1
    }
    return 1 + max(left, right)
}

fun main() {
    println(isBalanced(TreeNode(3, 9, 20, null, null, 15, 7).also(TreeNode::printNode)))
    println(isBalanced(TreeNode(1, 2, 2, 3, 3, null, null, 4, 4).also(TreeNode::printNode)))
    println(isBalanced(null))
}