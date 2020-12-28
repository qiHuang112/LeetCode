package leetcode

import java.util.*

/*
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:
输入:

    2
   / \
  1   3

输出:
1

示例 2:
输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7

注意: 您可以假设树（即给定的根节点）不为 NULL。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findBottomLeftValue(root: TreeNode?): Int {
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    var res = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            queue.pop().apply {
                if (i == 1) {
                    res = `val`
                }
                left?.let(queue::offer)
                right?.let(queue::offer)
            }
        }
    }
    return res
}

fun main() {
    println(findBottomLeftValue(TreeNode(2, 1, 3)))
    println(findBottomLeftValue(TreeNode(1, 2, 3, 4, null, 5, 6, null, null, 7).also(TreeNode::printNode)))
}