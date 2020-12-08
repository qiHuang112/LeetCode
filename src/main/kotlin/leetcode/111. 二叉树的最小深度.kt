package leetcode

import java.util.*

/*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。

示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：2

示例 2：
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

提示：
树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 带深度信息的深度优先搜索
 */
private fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val left = minDepth(root.left)
    val right = minDepth(root.right)
    if (left == 0 || right == 0) return 1 + left + right
    return 1 + minOf(left, right)
}

/**
 * 递归
 */
private fun minDepth2(root: TreeNode?): Int {
    if (root == null) return 0
    if (root.left == null && root.right == null) return 1
    if (root.left == null) return 1 + minDepth2(root.right)
    if (root.right == null) return 1 + minDepth2(root.left)
    return 1 + minOf(minDepth2(root.left), minDepth2(root.right))
}

/**
 * 迭代
 */
private fun minDepth3(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    var level = 0
    while (queue.isNotEmpty()) {
        level++
        val size = queue.size
        for (i in 1..size) {
            val node = queue.pop()
            if (node.left == null && node.right == null) {
                return level
            }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
    }
    return level
}

fun main() {
    println(minDepth(TreeNode(3, 9, 20, null, null, 15, 7)))
    println(minDepth(TreeNode(2, null, 3, null, 4, null, 5, null, 6)))
}