package leetcode

import java.util.*
import kotlin.collections.ArrayList

/*
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :
         1
    3   2   4
5    6

返回其后序遍历: [5,6,3,2,4,1].

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Node590(var `val`: Int) {
    var children: List<Node590?> = listOf()
}
/**
 * 递归法
 */
private fun postorder1(root: Node590?): List<Int> {
    val res = ArrayList<Int>()
    dfs(res, root)
    return res
}

private fun dfs(list: ArrayList<Int>, root: Node590?) {
    if (root == null) {
        return
    }
    for (node in root.children) {
        dfs(list, node)
    }
    list.add(root.`val`)
}

/**
 * 迭代法
 */
private fun postorder(root: Node590?): List<Int> {
    val res = LinkedList<Int>()
    val stack = Stack<Node590>()
    root?.let(stack::push)
    while (stack.isNotEmpty()) {
        stack.pop().let {
            res.addFirst(it.`val`)
            it.children.forEach(stack::push)
        }
    }
    return res
}

fun main() {
    val root = Node590(1)
    root.children = listOf(Node590(3), Node590(2), Node590(4))
    root.children[0]!!.children = listOf(Node590(5), Node590(6))
    println(postorder(root))
}