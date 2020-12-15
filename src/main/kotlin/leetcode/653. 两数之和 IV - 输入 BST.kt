package leetcode

import java.util.*

/*
给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
案例 1:

输入:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

输出: True

案例 2:
输入:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

输出: False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findTarget(root: TreeNode?, k: Int): Boolean {
    val set = hashSetOf<Int>()
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            queue.pop().apply {
                if (set.contains(k - `val`)) {
                    return true
                }
                set.add(`val`)
                left?.let(queue::offer)
                right?.let(queue::offer)
            }
        }
    }
    return false
}

fun main() {
    println(findTarget(TreeNode(5, 3, 6, 2, 4, null, 7), 9))
    println(findTarget(TreeNode(5, 3, 6, 2, 4, null, 7), 28))
}