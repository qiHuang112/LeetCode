package leetcode

import java.util.*

/*
您需要在二叉树的每一行中找到最大的值。

示例：

输入:

          1
         / \
        3   2
       / \   \
      5   3   9

输出: [1, 3, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun largestValues(root: TreeNode?): List<Int> {
    val queue = LinkedList<TreeNode>()
    val res = mutableListOf<Int>()
    root?.let(queue::offer)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var max = queue.peek().`val`
        for (i in 1..size) {
            queue.pop().let {
                max = maxOf(max, it.`val`)
                it.left?.let(queue::offer)
                it.right?.let(queue::offer)
            }
        }
        res.add(max)
    }
    return res
}

fun main() {
    println(largestValues(TreeNode(1, 3, 2, 5, 3, null, 9)))
}