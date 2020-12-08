package leetcode

/*
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:
输入: 1->1->2
输出: 1->2

示例 2:
输入: 1->1->2->3->3
输出: 1->2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    if (head.`val` == head.next!!.`val`) return deleteDuplicates(head.next)
    head.next = deleteDuplicates(head.next)
    return head
}

fun main() {
    println(deleteDuplicates(ListNode(1, 1, 2)))
    println(deleteDuplicates(ListNode(1, 1, 2, 3, 3)))
    println(deleteDuplicates(ListNode(1, 2, 2)))
}