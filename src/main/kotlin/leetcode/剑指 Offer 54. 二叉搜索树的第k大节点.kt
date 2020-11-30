package leetcode

/*
给定一棵二叉搜索树，请找出其中第k大的节点。

 

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4

限制：
1 ≤ k ≤ 二叉搜索树元素个数
 */
/**
 * 二叉搜索树的中序遍历是从小到大排序的，从right向left遍历二叉树，就是从大到小排序的
 * 遍历k次拿到节点值即可
 */
private fun kthLargest(root: TreeNode?, k: Int): Int {
    var res = 0
    var count = 1
    fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.right)
        if (count++ == k) {
            res = node.`val`
            return
        }
        dfs(node.left)
    }
    dfs(root)
    return res
}

fun main() {
    println(kthLargest(TreeNode(3, 1, 4, null, 2), 1))
    println(kthLargest(TreeNode(5, 3, 6, 2, 4, null, null, 1), 3))
}