package leetcode

import java.util.*

/*
设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
请实现 KthLargest 类：

KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
int add(int val) 返回当前数据流中第 k 大的元素。

示例：
输入：
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
输出：
[null, 4, 5, 5, 8, 8]

解释：
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
 
提示：
1 <= k <= 10^4
0 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
-10^4 <= val <= 10^4
最多调用 add 方法 10^4 次
题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 超时
 */
private class KthLargest1(val k: Int, nums: IntArray) {
    val res = LinkedList<Int>()

    init {
        nums.forEach {
            add(it)
        }
    }

    fun add(`val`: Int): Int {
        if (res.isEmpty()) {
            res.add(`val`)
            return `val`
        }
        if (res.size >= k && res[k - 1] >= `val`) {
            return res[k - 1]
        }
        addToRes(`val`, 0, minOf(res.size, k) - 1)
        return if (k - 1 < res.size) res[k - 1] else `val`
    }

    private fun addToRes(value: Int, left: Int, right: Int) {
        if (value >= res[left]) {
            res.add(left, value)
            return
        }
        if (value < res[right]) {
            res.add(right + 1, value)
            return
        }
        val mid = (right - left) / 2 + left
        if (value >= res[mid]) {
            addToRes(value, left, mid - 1)
        } else {
            addToRes(value, mid + 1, right)
        }
    }
}

/**
 * 优先队列实现
 */
private class KthLargest(val k: Int, nums: IntArray) {

    val queue = PriorityQueue<Int>()

    init {
        nums.forEach {
            add(it)
        }
    }

    fun add(`val`: Int): Int {
        if (queue.size < k) {
            queue.add(`val`)
        } else if (`val` > queue.peek()) {
            queue.poll()
            queue.add(`val`)
        }
        return queue.peek()
    }
}

fun main() {
    KthLargest(3, intArrayOf(4, 5, 8, 2)).apply {
        println(add(3))
        println(add(5))
        println(add(10))
        println(add(9))
        println(add(4))
        println(add(10))
        println(add(9))
        println(add(4))
    }
}

/*
8,5,4
add 3 -> 8 5 4
add 5 -> 8 5 5
add 10 -> 10 8 5
add 9 -> 10 9 8
add 4 -> 10 9 8

 */