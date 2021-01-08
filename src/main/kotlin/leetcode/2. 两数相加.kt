package leetcode

/*
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.

示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]

示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]

提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val res = ListNode(0)
    var temp = res
    var temp1 = l1
    var temp2 = l2
    var carry = 0
    while (temp1 != null || temp2 != null) {
        val n1 = temp1?.`val` ?: 0
        val n2 = temp2?.`val` ?: 0
        val cur = n1 + n2 + carry
        carry = cur / 10
        temp.next = ListNode(cur % 10)
        temp = temp.next!!
        temp1 = temp1?.next
        temp2 = temp2?.next
    }
    if (carry == 1) temp.next = ListNode(1)
    return res.next
}

fun main() {
    println(addTwoNumbers(ListNode(2, 4, 3), ListNode(5, 6, 4)))
    println(addTwoNumbers(ListNode(0), ListNode(0)))
    println(addTwoNumbers(ListNode(9, 9, 9, 9, 9, 9, 9), ListNode(9, 9, 9, 9)))

}