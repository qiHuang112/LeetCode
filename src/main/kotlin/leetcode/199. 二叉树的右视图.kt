package leetcode

/*
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun rightSideView(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) return res
    dfs(root, 0, res)
    return res
}

private fun dfs(root: TreeNode?, i: Int, res: MutableList<Int>) {
    if (root == null) return
    if (i == res.size) {
        res.add(root.`val`)
    } else {
        res[i] = root.`val`
    }
    dfs(root.left, i + 1, res)
    dfs(root.right, i + 1, res)
}

fun main() {
    println(rightSideView(TreeNode(1, 2, 3, null, 5, null, 4)))
}