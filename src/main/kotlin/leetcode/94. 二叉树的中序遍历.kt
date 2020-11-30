package leetcode

/*
给定一个二叉树的根节点 root ，返回它的 中序 遍历。

示例 1：
输入：root = [1,null,2,3]
输出：[1,3,2]

示例 2：
输入：root = []
输出：[]

示例 3：
输入：root = [1]
输出：[1]

示例 4：
输入：root = [1,2]
输出：[2,1]

示例 5：
输入：root = [1,null,2]
输出：[1,2]
 */
private fun inorderTraversal(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    dfs(res, root)
    return res
}

private fun dfs(list: MutableList<Int>, root: TreeNode?) {
    if (root == null) return
    dfs(list, root.left)
    list.add(root.`val`)
    dfs(list, root.right)
}

fun main() {
    println(inorderTraversal(TreeNode(1, null, 2, 3)))
    println(inorderTraversal(null))
    println(inorderTraversal(TreeNode(1)))
    println(inorderTraversal(TreeNode(1, 2)))
    println(inorderTraversal(TreeNode(1, null, 2)))
}

