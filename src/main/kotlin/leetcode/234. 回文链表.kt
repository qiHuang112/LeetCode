package leetcode

/*
请判断一个链表是否为回文链表。

示例 1:
输入: 1->2
输出: false

示例 2:
输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 保存为list，然后判断是否回文
 */
private fun isPalindrome(head: ListNode?): Boolean {
    if (head?.next == null) return true
    val list = mutableListOf<Int>()
    var temp = head
    while (temp != null) {
        list.add(temp.`val`)
        temp = temp.next
    }
    for (i in 0..list.size / 2) {
        if (list[i] != list[list.lastIndex - i]) {
            return false
        }
    }
    return true
}

fun main() {
    println(isPalindrome(ListNode(1, 2)))
    println(isPalindrome(ListNode(1, 2, 2, 1)))
    println(isPalindrome(null))
}