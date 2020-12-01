package leetcode

import kotlin.math.round

/*
实现一个函数，检查一棵二叉树是否为二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 */
private var pre = Long.MIN_VALUE
private fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) return true
    val left = isValidBST(root.left)
    if (root.`val` <= pre) return false
    pre = root.`val`.toLong()
    val right = isValidBST(root.right)
    return left && right
}

fun main() {
    println(isValidBST(TreeNode(2, 1, 3).also(TreeNode::printNode)))
    println(isValidBST(TreeNode(5, 1, 4, null, null, 3, 6).also(TreeNode::printNode)))
    println(isValidBST(TreeNode(10, 5, 15, null, null, 6, 20).also(TreeNode::printNode)))
}