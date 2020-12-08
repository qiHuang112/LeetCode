package leetcode

import java.util.*

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

示例:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

提示：
pop、top 和 getMin 操作总是在 非空栈 上调用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class MinStack() {

    val min = LinkedList<Int>()
    val real = LinkedList<Int>()

    /** initialize your data structure here. */
    fun push(x: Int) {
        real.addLast(x)
        // 从排序数组中找到x应该在min中的位置
        // 1 在[0,2,3]中的位置 -> 返回1
        val index = getIndexFromMin(x)
        min.add(index, x)
    }

    /**
     * 二分法查找index
     */
    private fun getIndexFromMin(x: Int): Int {
        var (left, right) = 0 to min.lastIndex
        while (left <= right) {
            val mid = (left + right) / 2
            if (min[mid] == x) {
                return mid
            }
            if (min[mid] > x) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun pop() {
        val cur = real.removeLast()
        min.removeAt(min.indexOf(cur))
    }

    fun top(): Int {
        return real.last
    }

    fun getMin(): Int {
        return min.first
    }

}

fun main() {
    MinStack().apply {
        push(-2)
        push(0)
        push(-3)
        println(getMin())
        pop()
        println(top())
        println(getMin())
    }
}