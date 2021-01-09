package leetcode

/*
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
调用 next() 将返回二叉搜索树中的下一个最小的数。

示例：

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false

提示：

next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class BSTIterator(root: TreeNode?) {
    val arr = mutableListOf<Int>()
    var index = 0

    init {
        dfs(root)
    }

    fun next(): Int {
        return arr[index++]
    }

    fun hasNext(): Boolean {
        return index < arr.size
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) return
        dfs(node.left)
        arr.add(node.`val`)
        dfs(node.right)
    }

}

fun main() {
    val iterator = BSTIterator(TreeNode(7, 3, 15, null, null, 9, 20))
    iterator.next().let(::println) // 返回 3
    iterator.next().let(::println) // 返回 7
    iterator.hasNext().let(::println) // 返回 true
    iterator.next().let(::println) // 返回 9
    iterator.hasNext().let(::println) // 返回 true
    iterator.next().let(::println) // 返回 15
    iterator.hasNext().let(::println) // 返回 true
    iterator.next().let(::println) // 返回 20
    iterator.hasNext().let(::println) // 返回 false
}