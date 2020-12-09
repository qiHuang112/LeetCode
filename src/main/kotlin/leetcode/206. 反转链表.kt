package leetcode

/*
反转一个单链表。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 递归
 */
private fun reverseList1(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val res = reverseList(head.next)!!
    var temp = res
    while (temp.next != null) {
        temp = temp.next!!
    }
    head.next = null
    temp.next = head
    return res
}

/**
 * 迭代
 */
private fun reverseList(head: ListNode?): ListNode? {
    var res: ListNode? = null
    var remain = head
    while (remain != null) {
        val node = remain.next
        remain.next = res
        res = remain
        remain = node
    }
    return res
}

fun main() {
    println(reverseList(ListNode(1, 2, 3, 4, 5)))
}