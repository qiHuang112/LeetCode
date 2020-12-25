package leetcode

import java.util.*

/*
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 使用数据结构  控件复杂度o(n)
 */
private fun reorderList1(head: ListNode?): Unit {
    val list = LinkedList<ListNode>()
    var temp = head
    while (temp != null) {
        list.addLast(temp)
        temp = temp.next
    }
    var (left, right) = 0 to list.lastIndex
    var flag = true
    while (left < right) {
        if (flag) {
            list[left++].next = list[right]
            list[right].next = null
        } else {
            list[right--].next = list[left]
            list[left].next = null
        }
        flag = !flag
    }
}

/**
 * 不用数据结构
 */
private fun reorderList(head: ListNode?): Unit {
    if (head?.next == null) return
    // 1. 将head用快慢指针分成两个长度相同的list
    // 完成后 head前半部分，slow为后半部分
    var slow = head
    var fast = head
    while (fast != null) {
        fast = fast.next?.next
        if (fast == null) {
            val temp = slow!!.next
            slow.next = null
            slow = temp
        } else {
            slow = slow!!.next
        }
    }
    // 2. 反转slow
    slow = reverse(slow)
    // 3. 组合head 和 slow
    var cur = head
    while (slow != null) {
        val temp1 = cur!!.next
        val temp2 = slow.next
        cur.next = slow
        slow.next = temp1
        cur = temp1
        slow = temp2
    }
}

private fun reverse(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var res: ListNode? = null
    var remind = head
    while (remind != null) {
        val temp = remind.next
        remind.next = res
        res = remind
        remind = temp
    }
    return res
}

fun main() {
    ListNode(1..5).apply(::reorderList).let(::println)
    ListNode(1..4).apply(::reorderList).let(::println)
}