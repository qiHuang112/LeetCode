package leetcode

/*
给出二叉树的根节点 root，树上每个节点都有一个不同的值。
如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
返回森林中的每棵树。你可以按任意顺序组织答案。

示例：
输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
输出：[[1,2,null,4],[6],[7]]

提示：
树中的节点数最大为 1000。
每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
to_delete.length <= 1000
to_delete 包含一些从 1 到 1000、各不相同的值。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-nodes-and-return-forest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 分析:每次删掉一个节点，会新增两个节点
 * 后续优化，在dfs中传入父节点信息，来判断是否将当前节点加入res，可以简化dfs的逻辑
 */
private fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode?> {
    val map = BooleanArray(1005)
    val res = mutableListOf<TreeNode?>()
    for (i in to_delete) {
        map[i] = true
    }
    // 加哨兵
    val guardNode = TreeNode(1004)
    guardNode.left = root
    if (root != null && !map[root.`val`]) {
        res.add(root)
    }
    fun dfs(node: TreeNode) {
        node.left?.let(::dfs)
        node.right?.let(::dfs)
        if (node.left != null && map[node.left!!.`val`]) {
            node.left?.left?.let(res::add)
            node.left?.right?.let(res::add)
            node.left = null
        }
        if (node.right != null && map[node.right!!.`val`]) {
            node.right?.left?.let(res::add)
            node.right?.right?.let(res::add)
            node.right = null
        }
    }
    dfs(guardNode)
    return res
}

fun main() {
    delNodes(TreeNode(1, 2, 3, 4, 5, 6, 7), intArrayOf(1, 3, 5)).forEach(::println)
    delNodes(TreeNode(1, 2, 3, 4, 5, 6, 7), intArrayOf(3, 5)).forEach(::println)
}