package leetcode

/*
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。

示例：
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun sumEvenGrandparent(root: TreeNode?): Int {
    if (root == null) return 0
    var current = 0
    if (root.`val` % 2 == 0) {
        current += root.left?.left?.`val` ?: 0
        current += root.left?.right?.`val` ?: 0
        current += root.right?.left?.`val` ?: 0
        current += root.right?.right?.`val` ?: 0
    }
    return current + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right)
}

fun main() {
    println(sumEvenGrandparent(TreeNode(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)))
}