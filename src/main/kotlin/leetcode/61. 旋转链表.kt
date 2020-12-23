package leetcode

import java.util.*

/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL

解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

示例 2:
输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL

解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力
 * 时间复杂度 o(n)
 * 空间复杂度 o(n)
 */
private fun rotateRight1(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head
    val arr = LinkedList<ListNode>()
    var temp = head
    while (temp != null) {
        arr.addLast(temp)
        temp = temp.next
    }
    val count = k % arr.size
    if (count == 0) return arr[0]
    val res = arr[arr.size - count]
    arr[arr.size - count - 1].next = null
    arr.last.next = arr.first
    return res
}

/**
 * 两次循环，第一次算长度，第二次定位节点
 * 时间复杂度o(n)
 * 空间复杂度o(1)
 */
private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head
    var len = 1
    var pre = head
    var cur = pre.next
    while (cur != null) {
        pre = cur
        cur = cur.next
        len++
    }
    if (len == 0 || k % len == 0) {
        return head
    }
    var count = len - k % len - 1
    val tail = pre
    pre = head
    cur = pre.next
    while (count != 0) {
        pre = cur!!
        cur = cur.next
        count--
    }
    pre!!.next = null
    tail!!.next = head
    return cur
}


fun main() {
    println(rotateRight(ListNode(1, 2, 3, 4, 5), 2))
    println(rotateRight(ListNode(0, 1, 2), 4))
}