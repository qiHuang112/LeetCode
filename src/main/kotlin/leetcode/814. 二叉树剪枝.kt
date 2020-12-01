package leetcode

/*
给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
返回移除了所有不包含 1 的子树的原二叉树。
( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

示例1:
输入: [1,null,0,0,1]
输出: [1,null,0,null,1]

示例2:
输入: [1,0,1,0,0,0,1]
输出: [1,null,1,null,1]

示例3:
输入: [1,1,0,1,1,0,1,0]
输出: [1,1,0,1,1,null,1]
 */
private fun pruneTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val left: Boolean = isAllZero(root.left)
    val right: Boolean = isAllZero(root.right)
    if (root.`val` == 0 && left && right) {
        return null
    }
    if (left) {
        root.left = null
    }
    if (right) {
        root.right = null
    }
    pruneTree(root.left)
    pruneTree(root.right)
    return root
}

private fun isAllZero(root: TreeNode?): Boolean {
    if (root == null) return true
    return root.`val` == 0 && isAllZero(root.left) && isAllZero(root.right)
}

fun main() {
    println(pruneTree(TreeNode(1, null, 0, 0, 1))?.also(TreeNode::printNode))
    println(pruneTree(TreeNode(1, 0, 1, 0, 0, 0, 1))?.also(TreeNode::printNode))
    println(pruneTree(TreeNode(1, 1, 0, 1, 1, 0, 1, 0))?.also(TreeNode::printNode))
}