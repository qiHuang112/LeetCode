package leetcode

import java.util.*

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun sortedListToBST(head: ListNode?): TreeNode? {
    val list = mutableListOf<Int>()
    var temp = head
    while (temp != null) {
        list.add(temp.`val`)
        temp = temp.next
    }
    fun getTreeNode(left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val mid = (left + right).ushr(1)
        val root = TreeNode(list[mid])
        root.left = getTreeNode(left, mid - 1)
        root.right = getTreeNode(mid + 1, right)
        return root
    }
    return getTreeNode(0, list.lastIndex)
}

fun main() {
    sortedListToBST(ListNode(-10, -3, 0, 5, 9))?.let(TreeNode::printNode)
    sortedListToBST(ListNode(1..10))?.let(TreeNode::printNode)
}