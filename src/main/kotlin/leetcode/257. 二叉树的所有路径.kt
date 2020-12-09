package leetcode

/*
给定一个二叉树，返回所有从根节点到叶子节点的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
输入:

   1
 /   \
2     3
 \
  5
输出: ["1->2->5", "1->3"]
解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun binaryTreePaths(root: TreeNode?): List<String> {
    val res = mutableListOf<String>()
    dfs(root, mutableListOf(), res)
    return res
}

private fun dfs(node: TreeNode?, temp: MutableList<Int>, res: MutableList<String>) {
    if (node == null) return
    if (node.left == null && node.right == null) {
        temp.add(node.`val`)
        res.add(temp.joinToString("->") { "$it" })
        temp.removeAt(temp.lastIndex)
        return
    }
    temp.add(node.`val`)
    dfs(node.left, temp, res)
    dfs(node.right, temp, res)
    temp.removeAt(temp.lastIndex)

}


fun main() {
    println(binaryTreePaths(TreeNode(1, 2, 3, null, 5)))
}