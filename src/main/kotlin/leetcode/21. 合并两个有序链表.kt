package leetcode

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    val res = ListNode(0)
    var (temp1, temp2, cur) = listOf(l1, l2, res)
    while (temp1 != null || temp2 != null) {
        if (temp1 == null) {
            cur!!.next = temp2
            break
        }
        if (temp2 == null) {
            cur!!.next = temp1
            break
        }
        if (temp1.`val` < temp2.`val`) {
            cur!!.next = ListNode(temp1.`val`)
            temp1 = temp1.next
        } else {
            cur!!.next = ListNode(temp2.`val`)
            temp2 = temp2.next
        }
        cur = cur.next
    }
    return res.next
}

fun main() {
    println(mergeTwoLists(ListNode(1, 2, 4), ListNode(1, 3, 4)))
}