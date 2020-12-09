package leetcode

import java.util.*

/*
使用队列实现栈的下列操作：

push(x) -- 元素 x 入栈
pop() -- 移除栈顶元素
top() -- 获取栈顶元素
empty() -- 返回栈是否为空

注意:
你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-stack-using-queues
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class MyStack {

    val queue = LinkedList<Int>()
    val temp = LinkedList<Int>()

    fun push(x: Int) {
        queue.offer(x)
    }

    fun pop(): Int {
        for (i in 1 until queue.size) {
            temp.offer(queue.pop())
        }
        val res = queue.pop()
        for (i in 0 until temp.size) {
            queue.offer(temp.pop())
        }
        return res
    }

    fun top(): Int {
        return queue.last
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }

}

fun main() {
    MyStack().apply {
        push(1)
        push(2)
        push(3)
        println(top())
        println(pop())
        println(top())
        println(pop())
        println(top())
        println(empty())
        println(pop())
        println(empty())

    }
}
/*
队列实现栈
队列先入先出
栈后入先出
1,2,3,4,5
 */