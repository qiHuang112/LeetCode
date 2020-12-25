package leetcode

import java.util.*

/*
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 递归实现
 */
private fun postorderTraversal1(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        dfs(node.right)
        res.add(node.`val`)
    }
    dfs(root)
    return res
}

/**
 * 迭代实现
 */
private fun postorderTraversal(root: TreeNode?): List<Int> {
    val res = LinkedList<Int>()
    val list = LinkedList<TreeNode>()
    root?.let(list::addFirst)
    while (list.isNotEmpty()) {
        val node = list.removeFirst()
        res.addFirst(node.`val`)
        node.left?.let(list::addFirst)
        node.right?.let(list::addFirst)
    }
    return res
}

fun main() {
    println(postorderTraversal(TreeNode(1, null, 2, 3)))
}