package leetcode

/*
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1：
输入：root = [2,2,5,null,null,5,7]
输出：5
解释：最小的值是 2 ，第二小的值是 5 。

示例 2：
输入：root = [2,2,2]
输出：-1
解释：最小的值是 2, 但是不存在第二小的值。

提示：
树中节点数目在范围 [1, 25] 内
1 <= Node.val <= 231 - 1
对于树中每个节点 root.val == min(root.left.val, root.right.val)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 阅读理解题，写了半天发现题目理解错了
 */
private fun findSecondMinimumValue1(root: TreeNode?): Int {
    var min1 = -1
    var min2 = -1
    fun dfs(node: TreeNode?) {
        if (node == null) return
        if (node.left == null || node.right == null) {
            return
        }
        val cur = minOf(node.left!!.`val`, node.right!!.`val`)
        when {
            min1 == -1 -> min1 = cur
            min1 > cur -> {
                min2 = min1
                min1 = cur
            }
            min2 == -1 -> min2 = cur
            min2 > cur -> min2 = cur
        }
        dfs(node.left)
        dfs(node.right)
    }
    dfs(root)
    return min2
}

/**
 * 找出第一个不等于root.val的节点值
 */
private fun findSecondMinimumValue(root: TreeNode?): Int {
    return dfs(root, root!!.`val`)
}

private fun dfs(root: TreeNode?, min: Int): Int {
    if (root == null) return -1
    if (root.`val` != min) {
        return root.`val`
    }
    val left = dfs(root.left, min)
    val right = dfs(root.right, min)
    if (left == -1 && right == -1) {
        return -1
    }
    if (left == -1 || right == -1) {
        return left + right + 1
    }
    return minOf(left, right)
}

fun main() {
    println(findSecondMinimumValue(TreeNode(2, 2, 5, null, null, 5, 7)))
    println(findSecondMinimumValue(TreeNode(2, 2, 2)))
    println(findSecondMinimumValue(TreeNode(5, 5, 6)))
}