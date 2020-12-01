package leetcode

/*
给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

3
解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 */
private var res = 0
private fun pathSum(root: TreeNode?, sum: Int): Int {
    if (root == null) return 0
    dfs(root, sum)
    return res
}

private fun dfs(root: TreeNode?, sum: Int) {
    if (root == null) return
    dfs(root.left, sum)
    res += count(root, sum)
    dfs(root.right, sum)
}

/**
 * 以root为首个节点，sum为目标和的有效路径数
 */
private fun count(root: TreeNode?, sum: Int): Int {
    if (root == null) return 0
    var temp = 0
    if (sum == root.`val`) {
        temp = 1
    }
    return temp + count(root.left, sum - root.`val`) + count(root.right, sum - root.`val`)
}

fun main() {
    println(pathSum(TreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1).also(TreeNode::printNode), 22))
}