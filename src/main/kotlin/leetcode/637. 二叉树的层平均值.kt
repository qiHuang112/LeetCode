package leetcode

import java.util.*

/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

示例 1：
输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 
提示：
节点值的范围在32位有符号整数范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun averageOfLevels(root: TreeNode?): DoubleArray {
    val res = mutableListOf<Double>()
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    while (queue.isNotEmpty()) {
        val size = queue.size
        var total = 0.0
        for (i in 1..size) {
            queue.pop().apply {
                total += `val`
                left?.let(queue::offer)
                right?.let(queue::offer)
            }
        }
        res.add(total / size)
    }
    return res.toDoubleArray()
}

fun main() {
    println(averageOfLevels(TreeNode(3, 9, 20, null, null, 15, 7)).contentToString())
}