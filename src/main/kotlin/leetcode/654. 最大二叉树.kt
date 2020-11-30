package leetcode

/*
给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：

二叉树的根是数组中的最大元素。
左子树是通过数组中最大值左边部分构造出的最大二叉树。
右子树是通过数组中最大值右边部分构造出的最大二叉树。
通过给定的数组构建最大二叉树，并且输出这个树的根节点。

示例 ：

输入：[3,2,1,6,0,5]
输出：返回下面这棵树的根节点：

      6
    /   \
   3     5
    \    /
     2  0
       \
        1
 */
private fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
    return buildTreeNode(nums, 0, nums.size - 1)
}

private fun buildTreeNode(nums: IntArray, left: Int, right: Int): TreeNode? {
    if (left > right) return null
    var max = nums[left]
    var index = left
    for (i in left + 1..right) {
        if (nums[i] > max) {
            max = nums[i]
            index = i
        }
    }
    val res = TreeNode(max)
    res.left = buildTreeNode(nums, left, index - 1)
    res.right = buildTreeNode(nums, index + 1, right)
    return res
}

fun main() {
    constructMaximumBinaryTree(intArrayOf(3, 2, 1, 6, 0, 5))?.printNode()
}