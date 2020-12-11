package leetcode

/*
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subtree-of-another-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
    if (t == null) return true
    if (s == null) return false
    return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)
}

private fun isSame(s: TreeNode?, t: TreeNode?): Boolean {
    if (s == null && t == null) return true
    if (s == null || t == null) return false
    return s.`val` == t.`val` && isSame(s.left, t.left) && isSame(s.right, t.right)
}

fun main() {
    println(isSubtree(TreeNode(3, 4, 5, 1, 2), TreeNode(4, 1, 2)))
    println(isSubtree(TreeNode(3, 4, 5, 1, 2, null, null, null, null, 0), TreeNode(4, 1, 2)))
}