package leetcode

/*
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1:直接解出来
 */
private fun buildTree1(inorder: IntArray, postorder: IntArray): TreeNode? {
    return buildTree1(inorder, 0, inorder.lastIndex, postorder, 0, postorder.lastIndex)
}

private fun buildTree1(inorder: IntArray, l1: Int, r1: Int, postorder: IntArray, l2: Int, r2: Int): TreeNode? {
    // 数组为空，返回null
    if (l1 > r1) return null
    val root = TreeNode(postorder[r2])
    // 中序遍历中的根节点index
    val rootIndex = (l1..r1).first { inorder[it] == postorder[r2] }
    // 左子树长度
    val leftLength = rootIndex - l1
    root.left = buildTree1(inorder, l1, l1 + leftLength - 1, postorder, l2, l2 + leftLength - 1)
    root.right = buildTree1(inorder, rootIndex + 1, r1, postorder, l2 + leftLength, r2 - 1)
    return root
}

/**
 * hashmap保存inorder中每个节点的index
 */
private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    val hashMap = inorder.foldIndexed(mutableMapOf<Int, Int>()) { index, acc, i ->
        acc[i] = index
        acc
    }

    fun buildTree(inorder: IntArray, l1: Int, r1: Int, postorder: IntArray, l2: Int, r2: Int): TreeNode? {
        // 数组为空，返回null
        if (l1 > r1) return null
        val root = TreeNode(postorder[r2])
        // 中序遍历中的根节点index
        val rootIndex = hashMap[postorder[r2]]!!
        // 左子树长度
        val leftLength = rootIndex - l1
        root.left = buildTree(inorder, l1, l1 + leftLength - 1, postorder, l2, l2 + leftLength - 1)
        root.right = buildTree(inorder, rootIndex + 1, r1, postorder, l2 + leftLength, r2 - 1)
        return root
    }
    return buildTree(inorder, 0, inorder.lastIndex, postorder, 0, postorder.lastIndex)
}

fun main() {
    buildTree(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))?.let(TreeNode::printNode)
}