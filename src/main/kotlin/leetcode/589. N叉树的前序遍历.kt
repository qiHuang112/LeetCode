package leetcode

/*
给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :
         1
    3   2   4
5    6
返回其前序遍历: [1,3,5,6,2,4]。
说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
private class Node589(var `val`: Int) {
    var children: List<Node589?> = listOf()
}

private fun preorder(root: Node589?): List<Int> {
    val res = ArrayList<Int>()
    dfs(res, root)
    return res
}

private fun dfs(list: ArrayList<Int>, root: Node589?) {
    if (root == null) {
        return
    }
    list.add(root.`val`)
    for (node in root.children) {
        dfs(list, node)
    }
}

fun main() {

    val root = Node589(1)
    root.children = listOf(Node589(3), Node589(2), Node589(4))
    root.children[0]!!.children = listOf(Node589(5), Node589(6))
    println(preorder(root))
}