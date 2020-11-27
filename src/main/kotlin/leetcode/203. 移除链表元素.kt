package leetcode

/**
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    if (head == null) return head
    if (head.`val` == `val`) return removeElements(head.next, `val`)
    var temp = head
    while (temp?.next != null) {
        if (temp.next!!.`val` == `val`) {
            temp.next = temp.next!!.next
        } else {
            temp = temp.next
        }
    }
    return head
}

fun main() {
    println(removeElements(ListNode(1, 2, 6, 3, 4, 5, 6), 6))
    println(removeElements(ListNode(1, 2, 2, 1), 2))
}