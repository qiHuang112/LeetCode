package leetcode

/*
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶：
如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例：
输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 方法1：反转链表
 * 方法2：数据结构 空间换时间
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var temp1 = reverseNode(l1)
    var temp2 = reverseNode(l2)
    var carry = 0
    val res = ListNode(0)
    while (temp1 != null || temp2 != null) {
        val cur = (temp1?.`val` ?: 0) + (temp2?.`val` ?: 0) + carry
        carry = cur / 10
        val temp = res.next
        val node = ListNode(cur % 10)
        node.next = temp
        res.next = node
        temp1 = temp1?.next
        temp2 = temp2?.next
    }
    if (carry != 0) {
        val temp = res.next
        val node = ListNode(1)
        node.next = temp
        res.next = node
    }
    return res.next
}

private fun reverseNode(node: ListNode?): ListNode? {
    var res: ListNode? = null
    var remind = node
    while (remind != null) {
        val temp = remind.next
        remind.next = res
        res = remind
        remind = temp
    }
    return res
}

fun main() {
    println(addTwoNumbers(ListNode(7, 2, 4, 3), ListNode(5, 6, 4)))
    println(addTwoNumbers(ListNode(7, 2, 4, 3), ListNode(0)))
    println(addTwoNumbers(ListNode(0), ListNode(0)))
}