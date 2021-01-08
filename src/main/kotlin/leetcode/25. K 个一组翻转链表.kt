package leetcode

/*
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例：
给你这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5

说明：
你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    // 1. 先计算有多少组需要翻转, 一共翻转limit次
    var len = 0
    var temp = head
    while (temp != null) {
        temp = temp.next
        len++
    }
    val limit = len / k
    // 翻转limit次
    temp = head
    val res = ListNode(0)
    repeat(limit) {
        var curRes: ListNode? = null
        var curRemind = temp
        repeat(k) {
            val curTemp = curRemind?.next
            curRemind?.next = curRes
            curRes = curRemind
            curRemind = curTemp
        }
        res.add(curRes)
        temp = curRemind
    }
    res.add(temp)
    return res.next
}

private fun ListNode.add(node: ListNode?): ListNode {
    var temp = this
    while (temp.next != null) {
        temp = temp.next!!
    }
    temp.next = node
    return this
}

fun main() {
    println(reverseKGroup(ListNode(1..5), 2))
    println(reverseKGroup(ListNode(1..5), 3))
    println(reverseKGroup(ListNode(1..5), 1))
    println(reverseKGroup(ListNode(1..2), 2))
}