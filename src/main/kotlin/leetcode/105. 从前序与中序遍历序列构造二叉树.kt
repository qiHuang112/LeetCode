package leetcode

/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty()) return null
    return build(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
}

private fun build(preorder: IntArray, p1: Int, p2: Int, inorder: IntArray, i1: Int, i2: Int): TreeNode? {
    if (p2 - p1 != i2 - i1 || p1 > p2 || p1 >= preorder.size) {
        return null
    }
    val res = TreeNode(preorder[p1])
    if (p1 == p2) {
        return res
    }
    // preorder [p1, p1] [p1+1, p1+count] [p1+count+1, p2]
    // inorder [l1, root-1] [root, root] [root+1, l2]
    val rootIndex = inorder.indexOf(preorder[p1])
    val leftCount = rootIndex - i1
    res.left = build(preorder, p1 + 1, p1 + leftCount, inorder, i1, rootIndex - 1)
    res.right = build(preorder, p1 + leftCount + 1, p2, inorder, rootIndex + 1, i2)
    return res
}

fun main() {
    println(buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))?.also(TreeNode::printNode))
    println(buildTree(intArrayOf(1, 2), intArrayOf(2, 1))?.also(TreeNode::printNode))
    println(buildTree(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))?.also(TreeNode::printNode))
}