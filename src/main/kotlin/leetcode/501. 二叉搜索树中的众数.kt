package leetcode

import java.util.*

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序
进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力
 * 没有用到BST的性质
 * 可以用中序遍历的方式有更低复杂度的实现
 */
private fun findMode(root: TreeNode?): IntArray {
    val queue = LinkedList<TreeNode>()
    root?.let(queue::offer)
    val map = hashMapOf<Int, Int>()
    var maxCount = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 1..size) {
            val node = queue.pop()
            map[node.`val`] = map.getOrDefault(node.`val`, 0) + 1
            maxCount = maxOf(maxCount, map[node.`val`]!!)
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
    }
    return map.keys.filter { map[it] == maxCount }.toIntArray()
}

fun main() {
    println(findMode(TreeNode(1, null, 2, 2)).contentToString())
}