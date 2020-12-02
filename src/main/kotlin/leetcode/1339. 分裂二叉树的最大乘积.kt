package leetcode

/*
给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。

示例 1：
输入：root = [1,2,3,4,5,6]
输出：110

示例 2：
输入：root = [1,null,2,3,4,null,null,5,6]
输出：90

示例 3：
输入：root = [2,3,9,10,7,8,6,5,4,11,1]
输出：1025

示例 4：
输入：root = [1,1]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun maxProduct(root: TreeNode?): Int {
    // 转累加树，并将值以list的方式记录下来
    val values = mutableListOf<Int>()
    format(root, values)
    if (values.size <= 1) return 0
    var res = 0L
    for (v in values) {
        res = maxOf(res, v.toLong() * (root!!.`val` - v))
    }
    return (res % 1000000007).toInt()
}

private fun format(root: TreeNode?, values: MutableList<Int>) {
    if (root == null) return
    format(root.left, values)
    format(root.right, values)
    root.`val` += (root.left?.`val` ?: 0) + (root.right?.`val` ?: 0)
    values.add(root.`val`)
}

fun main() {
    println(maxProduct(TreeNode(1, 2, 3, 4, 5, 6)))
    println(maxProduct(TreeNode(1, null, 2, 3, 4, null, null, 5, 6)))
    println(maxProduct(TreeNode(2, 3, 9, 10, 7, 8, 6, 5, 4, 11, 1)))
    println(maxProduct(TreeNode(1, 1)))
}