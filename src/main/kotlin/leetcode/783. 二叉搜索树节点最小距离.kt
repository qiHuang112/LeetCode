package leetcode

/*
给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。

示例：
输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树节点对象(TreeNode object)，而不是数组。

给定的树 [4,2,6,1,3,null,null] 可表示为下图:

          4
        /   \
      2      6
     / \
    1   3

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 
注意：
二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。
本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * BST的中序遍历是有序的
 */
private fun minDiffInBST(root: TreeNode?): Int {
    var res = Int.MAX_VALUE
    var a: Int? = null
    var b: Int
    fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        if (a != null) {
            b = a!!
            a = node.`val`
            res = minOf(res, a!! - b)
        } else {
            a = node.`val`
        }
        dfs(node.right)
    }
    dfs(root)
    return res
}

fun main() {
//    println(minDiffInBST(TreeNode(4, 2, 6, 1, 3, null, null)))
    println(minDiffInBST(TreeNode(90, 69, null, 49, 89, null, 52, null, null, null, null).also(TreeNode::printNode)))
}