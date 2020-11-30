package leetcode

/*
对链表进行插入排序。

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 */
private fun insertionSortList(head: ListNode?): ListNode? {
    val res: ListNode = ListNode(Int.MIN_VALUE)
    var cur = head
    while (cur != null) {
        res.insert(cur.`val`)
        cur = cur.next
    }
    return res.next
}

/**
 * 插入排序
 */
private fun ListNode.insert(value: Int) {
    // 最后一个节点
    if (this.next == null) {
        this.next = ListNode(value)
        return
    }
    // 中间节点
    if (this.next!!.`val` > value) {
        val node = ListNode(value)
        node.next = this.next
        this.next = node
        return
    }
    // 递归
    this.next!!.insert(value)
}

/*
2,4
-> 3
*/
fun main() {
    println(insertionSortList(ListNode(4, 2, 1, 3)))
    println(insertionSortList(ListNode(-1, 5, 3, 4, 0)))
}