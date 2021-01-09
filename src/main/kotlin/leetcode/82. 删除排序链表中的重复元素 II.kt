package leetcode

import java.util.*

/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5

示例 2:
输入: 1->1->1->2->3
输出: 2->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun deleteDuplicates1(head: ListNode?): ListNode? {
    val map = TreeMap<Int, Int>()
    var temp = head
    while (temp != null) {
        map[temp.`val`] = (map[temp.`val`] ?: 0) + 1
        temp = temp.next
    }
    val res = ListNode(0)
    temp = res
    for (key in map.keys) {
        if (map[key]!! == 1) {
            temp?.next = ListNode(key)
            temp = temp?.next
        }
    }
    return res.next
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    var cur = head
    if (cur.`val` == cur.next!!.`val`) {
        while (cur != null && cur.`val` == cur.next?.`val`) {
            cur = cur.next
        }
        return deleteDuplicates(cur!!.next)
    }
    cur.next = deleteDuplicates(cur.next)
    return cur
}

fun main() {
    println(deleteDuplicates(ListNode(1, 2, 3, 3, 4, 4, 5)))
    println(deleteDuplicates(ListNode(1, 1, 1, 2, 3)))
}