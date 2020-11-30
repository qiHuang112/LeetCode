package leetcode

/*
给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。

示例 ：

输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

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
            \
             7
              \
               8
                \
                 9
 */
private fun increasingBST(root: TreeNode?): TreeNode? {
    val nodes = mutableListOf<Int>()
    dfs(nodes, root)
    val res = TreeNode(0)
    var temp = res
    for (node in nodes) {
        temp.right = TreeNode(node)
        temp = temp.right!!
    }
    return res.right
}

private fun dfs(nodes: MutableList<Int>, root: TreeNode?) {
    if (root == null) return
    dfs(nodes, root.left)
    nodes.add(root.`val`)
    dfs(nodes, root.right)
}

fun main() {
    increasingBST(TreeNode(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9).also(TreeNode::printNode))?.printNode('_')
}