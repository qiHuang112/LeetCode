package leetcode

import java.util.*

/*
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 
进阶：
你可以运用递归和迭代两种方法解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 递归
 */
private fun isSymmetric(root: TreeNode?, other: TreeNode? = root): Boolean {
    if (root == null && other == null) return true
    if (root == null || other == null) return false
    return root.`val` == other.`val` && isSymmetric(root.left, other.right) && isSymmetric(root.right, other.left)
}

/**
 * 迭代
 */
private fun isSymmetric(root: TreeNode?): Boolean {
    val queue = LinkedList<TreeNode?>().apply {
        addFirst(root)
        addFirst(root)
    }
    while (queue.isNotEmpty()) {
        val left = queue.pollFirst()
        val right = queue.pollFirst()
        if (left == null && right == null) {
            continue
        }
        if (left == null || right == null) {
            return false
        }
        if (left.`val` != right.`val`) {
            return false
        }
        queue.addFirst(left.left)
        queue.addFirst(right.right)
        queue.addFirst(left.right)
        queue.addFirst(right.left)
    }
    return true
}

fun main() {
    println(isSymmetric(TreeNode(1, 2, 2, 3, 4, 4, 3)))
    println(isSymmetric(TreeNode(1, 2, 2, null, 3, null, 3)))
}