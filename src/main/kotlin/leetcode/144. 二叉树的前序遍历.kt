package leetcode

import java.util.*

/*
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

示例 1：
输入：root = [1,null,2,3]
输出：[1,2,3]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

示例 4：
输入：root = [1,2]
输出：[1,2]

示例 5：
输入：root = [1,null,2]
输出：[1,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun preorderTraversal1(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    dfs(root, res)
    return res
}

private fun dfs(root: TreeNode?, list: MutableList<Int>) {
    if (root == null) return
    list.add(root.`val`)
    dfs(root.left, list)
    dfs(root.right, list)
}

/**
 * 迭代
 */
private fun preorderTraversal(root: TreeNode?): List<Int> {
    val res = LinkedList<Int>()
    val list = LinkedList<TreeNode>()
    root?.let(list::addLast)
    while (list.isNotEmpty()) {
        val node = list.removeLast()
        res.addLast(node.`val`)
        node.right?.let(list::addLast)
        node.left?.let(list::addLast)
    }
    return res
}

fun main() {
    println(preorderTraversal(TreeNode(1, null, 2, 3).also(TreeNode::printNode)))
    println(preorderTraversal(null))
    println(preorderTraversal(TreeNode(1).also(TreeNode::printNode)))
    println(preorderTraversal(TreeNode(1, 2).also(TreeNode::printNode)))
    println(preorderTraversal(TreeNode(1, null, 2).also(TreeNode::printNode)))
    println(preorderTraversal(TreeNode(1, 4, 3, 2).also(TreeNode::printNode)))
}