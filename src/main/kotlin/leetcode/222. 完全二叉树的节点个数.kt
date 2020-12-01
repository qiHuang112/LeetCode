package leetcode

/*
给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

示例:

输入:
    1
   / \
  2   3
 / \  /
4  5 6
 */
private fun countNodes(root: TreeNode?): Int {
    fun TreeNode?.getHigh(): Int = if (this == null) 0 else 1 + this.left.getHigh()
    // 树的最大高度
    val high = root.getHigh()
    if (high <= 1) {
        return high
    }
    if (high == 2) {
        return if (root!!.right == null) 2 else 3
    }
    // 做high - 1 次左右选择，确定最后一个节点的位置
    var temp = root!!
    var count = 0
    for (i in high - 2 downTo 0) {
        if (temp.left.getHigh() == temp.right.getHigh()) {
            count += 1 shl i
            temp = temp.right!!
        } else {
            temp = temp.left!!
        }
    }
    return (1 shl (high - 1)) + count
}


fun main() {
    println(countNodes(TreeNode(1)))
    println(countNodes(TreeNode(1, 2)))
    println(countNodes(TreeNode(1, 2, 3)))
    println(countNodes(TreeNode(1, 2, 3, 4)))
    println(countNodes(TreeNode(1, 2, 3, 4, 5)))
    println(countNodes(TreeNode(1, 2, 3, 4, 5, 6)))
    println(countNodes(TreeNode(1, 2, 3, 4, 5, 6, 7)))
    println(countNodes(TreeNode(1, 2, 3, 4, 5, 6, 7, 8)))
}