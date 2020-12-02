package leetcode

/*
给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。

回想一下：

叶节点 是二叉树中没有子节点的节点
树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。

示例 1：
输入：root = [3,5,1,6,2,0,8,null,null,7,4]
输出：[2,7,4]
解释：
我们返回值为 2 的节点，在图中用黄色标记。
在图中用蓝色标记的是树的最深的节点。
注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。

示例 2：
输入：root = [1]
输出：[1]
解释：根节点是树中最深的节点，它是它本身的最近公共祖先。

示例 3：
输入：root = [0,1,3,null,2]
输出：[2]
解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    return getRes(root).first
}

/**
 * 输入节点
 * 返回节点的最深叶子结点的公共祖先和此节点的高度
 */
private fun getRes(root: TreeNode?): Pair<TreeNode?, Int> {
    if (root == null) return null to 0
    val (leftParent, leftHigh) = getRes(root.left)
    val (rightParent, rightHigh) = getRes(root.right)
    val parent = when {
        leftHigh > rightHigh -> leftParent
        leftHigh < rightHigh -> rightParent
        else -> root
    }
    return parent to 1 + maxOf(leftHigh, rightHigh)
}

fun main() {
    println(lcaDeepestLeaves(TreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)))
    println(lcaDeepestLeaves(TreeNode(1)))
    println(lcaDeepestLeaves(TreeNode(0, 1, 3, null, 2)))
}