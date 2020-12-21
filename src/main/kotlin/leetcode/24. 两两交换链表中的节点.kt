package leetcode

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]
 
提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1.单纯改值
 */
private fun swapPairs1(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val temp = head.`val`
    head.`val` = head.next!!.`val`
    head.next!!.`val` = temp
    head.next!!.next = swapPairs(head.next!!.next)
    return head
}

/**
 * 实际节点替换 - 递归实现
 */
private fun swapPairs2(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val res = head.next
    head.next = res!!.next
    res.next = head
    res.next!!.next = swapPairs(res.next!!.next)
    return res
}

/**
 * 实际节点替换 - 迭代
 */
private fun swapPairs(head: ListNode?): ListNode? {
    var pre: ListNode? = null
    var a = head
    var b = a?.next
    val res = b ?: a

    while (b != null){
        pre?.next = b
        a!!.next = b.next
        b.next = a

        pre = a
        a = a.next
        b = a?.next
    }
    return res
}

fun main() {
    println(swapPairs(null))
    println(swapPairs(ListNode(1)))
    println(swapPairs(ListNode(1, 2, 3, 4)))
    println(swapPairs(ListNode(1, 2, 3, 4, 5)))
    println(swapPairs(ListNode(1, 2, 3, 4, 5, 6)))
}