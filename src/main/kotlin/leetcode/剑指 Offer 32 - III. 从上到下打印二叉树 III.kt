package leetcode

import java.util.*

/*
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]
提示：
节点总数 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<LinkedList<Int>>()
    if (root == null) return res
    val queue = LinkedList<TreeNode>().apply { offer(root) }
    var flag = true
    while (queue.isNotEmpty()) {
        val size = queue.size
        val list = LinkedList<Int>()
        for (i in 1..size) {
            val node = queue.pop()
            if (flag) {
                list.addLast(node.`val`)
            } else {
                list.addFirst(node.`val`)
            }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
        flag = !flag
        res.add(list)
    }
    return res
}

fun main() {
    println(levelOrder(TreeNode(3, 9, 20, null, null, 15, 7)))
}