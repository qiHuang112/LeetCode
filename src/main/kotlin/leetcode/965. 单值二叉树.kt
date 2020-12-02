package leetcode

import java.util.*

/*
如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
只有给定的树是单值二叉树时，才返回 true；否则返回 false。

示例 1：
输入：[1,1,1,1,1,null,1]
输出：true

示例 2：
输入：[2,2,2,5,2]
输出：false

提示：
给定树的节点数范围是 [1, 100]。
每个节点的值都是整数，范围为 [0, 99] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/univalued-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isUnivalTree(root: TreeNode?): Boolean {
    if (root == null) return true
    val queue = LinkedList<TreeNode>().apply { offer(root) }
    var res = true
    var pre = -1
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.pop()
            if (pre == -1) {
                pre = node.`val`
            } else {
                res = pre == node.`val`
                if (!res) return false
            }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
    }
    return res
}

fun main() {
    println(isUnivalTree(TreeNode(1, 1, 1, 1, 1, null, 1)))
    println(isUnivalTree(TreeNode(2, 2, 2, 5, 2)))
}