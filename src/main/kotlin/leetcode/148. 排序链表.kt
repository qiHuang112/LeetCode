package leetcode

/*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
进阶：
你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

示例 1：
输入：head = [4,2,1,3]
输出：[1,2,3,4]

示例 2：
输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]

示例 3：
输入：head = []
输出：[]
 
提示：
链表中节点的数目在范围 [0, 5 * 10^4] 内
-10^5 <= Node.val <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 归并排序
 */
private fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
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
    // 2. 递归完成子序列排序
    var left = sortList(head)
    var right = sortList(slow)

    // 3.迭代完成结果排序
    val res = ListNode(0)
    var temp = res
    while (left != null || right != null) {
        if (left == null) {
            temp.next = right
            break
        }
        if (right == null) {
            temp.next = left
            break
        }
        if (left.`val` < right.`val`) {
            temp.next = ListNode(left.`val`)
            left = left.next
        } else {
            temp.next = ListNode(right.`val`)
            right = right.next
        }
        temp = temp.next!!
    }
    return res.next
}

fun main() {
    println(sortList(ListNode(10 downTo 1)))
    println(sortList(ListNode(4, 2, 1, 3)))
    println(sortList(ListNode(-1, 5, 3, 4, 0)))
}