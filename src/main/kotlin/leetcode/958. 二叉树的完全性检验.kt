package leetcode

import java.util.*

/*
给定一个二叉树，确定它是否是一个完全二叉树。

百度百科中对完全二叉树的定义如下：

若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）

输入：[1,2,3,4,5,6]
输出：true
解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。

输入：[1,2,3,4,5,null,7]
输出：false
解释：值为 7 的结点没有尽可能靠向左侧。
 */
/*
 * 思路：
 * 层序遍历二叉树
 * 如果遍历到null，则停止遍历
 * 停止遍历后，如果还存在未遍历到的节点，则说明不是满二叉树
 */
private fun isCompleteTree(root: TreeNode?): Boolean {
    if (root == null) return true
    val queue = LinkedList<TreeNode?>()
    queue.offer(root)
    while (queue.isNotEmpty()) {
        val node = queue.pop() ?: break
        queue.offer(node.left)
        queue.offer(node.right)
    }
    return queue.all { it == null }
}

fun main() {
    println(isCompleteTree(TreeNode(1, 2, 3, 4, 5, 6).also(TreeNode::printNode)))
    println(isCompleteTree(TreeNode(1, 2, 3, 4, 5, null, 7).also(TreeNode::printNode)))
    println(isCompleteTree(TreeNode(1, 2, null, 4, 5, null, 7).also(TreeNode::printNode)))
}