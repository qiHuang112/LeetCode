package leetcode

/*
给定一个二叉树，原地将它展开为一个单链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun flatten(root: TreeNode?) {
    if (root == null) return
    flatten(root.left)
    flatten(root.right)
    if (root.left == null) return
    val left = root.left
    var temp: TreeNode? = left!!
    while (temp!!.right != null) {
        temp = temp.right
    }
    temp.right = root.right
    root.right = left
    root.left = null
}

fun main() {
    val node = TreeNode(1, 2, 5, 3, 4, null, 6).also(TreeNode::printNode)
    flatten(node)
    node.printNode()
}