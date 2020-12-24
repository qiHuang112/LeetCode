package leetcode

/*
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 */
/**
 * 用数据结构
 * 时间复杂度 o(n)
 * 空间复杂度 o(n)
 */
private fun reverseBetween1(head: ListNode?, m: Int, n: Int): ListNode? {
    val nodes = mutableListOf<ListNode>()
    // 加哨兵
    val res = ListNode(0)
    res.next = head
    // 添加到list
    var temp: ListNode? = res
    while (temp != null) {
        nodes.add(temp)
        temp = temp.next
    }
    var pre = nodes[m - 1]
    // 中间部分 index m~n
    for (i in n downTo m) {
        pre.next = nodes[i]
        pre = nodes[i]
    }
    pre.next = if (n + 1 < nodes.size) nodes[n + 1] else null
    return res.next
}

/**
 * 不使用额外空间+一趟扫描
 * 时间复杂度 o(n)
 * 空间复杂度 o(1)
 */
private fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    // 加哨兵
    val res = ListNode(0)
    res.next = head

    // 左边不用反转的链表的最后一个节点 对应index = m-1
    var leftLast: ListNode? = null
    // 需要反转的链表的首节点 初始化时对应 index = m
    var remind: ListNode? = null
    // 右边不需要反转的节点 初始化时对应index = n，反转后作为leftLast的后一个节点
    var completed: ListNode?
    var temp: ListNode? = res
    for (i in 0 until n) {
        if (i == m - 1) {
            leftLast = temp!!
            remind = temp.next
        }
        temp = temp!!.next
    }
    completed = temp!!.next
    temp.next = null

    temp = remind
    while (temp != null) {
        val cur = temp.next
        temp.next = completed
        completed = temp
        temp = cur
    }
    leftLast?.next = completed
    return res.next
}

fun main() {
    println(reverseBetween(ListNode(1, 2, 3, 4, 5), 2, 4))
    println(reverseBetween(ListNode(1, 2, 3, 4, 5), 1, 5))
    println(reverseBetween(ListNode(1, 2, 3, 4, 5), 3, 5))
}