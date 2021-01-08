package leetcode

/*
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

示例 2：
输入：lists = []
输出：[]

示例 3：
输入：lists = [[]]
输出：[]

提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 直接暴力合并
 */
private fun mergeKLists(lists: Array<ListNode?>, start: Int = 0, end: Int = lists.lastIndex): ListNode? {
    if (start > end) return null
    if (start == end) return lists[start]
    val mid = (start + end).ushr(1)
    val left = mergeKLists(lists, start, mid)
    val right = mergeKLists(lists, mid + 1, end)
    return mergeTwoLists(left, right)
}

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1
    if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        return list1
    }
    list2.next = mergeTwoLists(list1, list2.next)
    return list2
}

fun main() {
    println(mergeKLists(arrayOf()))
    println(mergeKLists(arrayOf(null)))
    println(mergeKLists(arrayOf(ListNode(1, 4, 5), ListNode(1, 3, 4), ListNode(2, 6))))
}