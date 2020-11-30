package leetcode

/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
/**
 * 迭代实现
 */
private fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    // 结果
    var res: ListNode? = null
    // 剩余待反转
    var remain = head
    while (remain != null) {
        // 中间变量
        val temp = remain.next
        remain.next = res
        res = remain
        remain = temp
        println("*********")
        println(res)
        println(remain)
        println("*********")
    }
    return res
}

/**
 * 递归实现
 */
private fun reverseList1(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val last = head.`val`
    val res = reverseList1(head.next)
    var temp = res!!
    while (temp.next != null) {
        temp = temp.next!!
    }
    temp.next = ListNode(last)
    return res
}

fun main() {
    println(reverseList(ListNode(1, 2, 3, 4, 5, 6)))
//    println(reverseList(ListNode(1)))
//    println(reverseList(ListNode(1, 2)))
//    println(reverseList(null))
}