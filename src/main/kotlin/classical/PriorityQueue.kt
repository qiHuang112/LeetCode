package classical

/**
 * 思路：
 * 维护一个小顶堆
 * 新增元素，则将元素放到最后，并向上sift
 * 删除元素，则将最后一个元素放到第一个，向下sift
 */
class PriorityQueue {
    // 初始化queue的容量为16
    var queue = IntArray(16)

    // queue的真实存储元素个数
    var size = 0

    fun offer(v: Int): Boolean {
        // 如果最后一个元素超出最大容量，则扩容
        if (size >= queue.size) {
            grow()
        }
        siftUp(size++, v)
        return true
    }

    fun peek(): Int {
        return if (size <= 0) throw IndexOutOfBoundsException("没有元素") else queue[0]
    }

    fun poll(): Int {
        if (size <= 0) throw IndexOutOfBoundsException("没有元素")
        val res = queue[0]
        siftDown(0, queue[--size])
        return res
    }

    // 将v从index=i的位置向上移动，直到queue成为小顶堆
    private fun siftUp(i: Int, v: Int) {
        var child = i
        while (child > 0) {
            val parent = (child - 1).ushr(1)
            if (v >= queue[parent]) break
            queue[child] = queue[parent]
            child = parent
        }
        queue[child] = v
    }

    // 将v从index=i的位置向下移动，直到queue成为小顶堆
    private fun siftDown(i: Int, v: Int) {
        var parent = i
        while (parent.shl(1) + 1 < size) {
            var child = parent.shl(1) + 1
            if (child + 1 < size && queue[child + 1] < queue[child]) child++
            if (queue[child] >= v) break
            queue[parent] = queue[child]
            parent = child
        }
        queue[parent] = v
    }

    // 每次容量翻倍，如果容量已经到达Int.MAX_VALUE, 则抛出异常
    private fun grow() {
        if (queue.size == Int.MAX_VALUE) throw OutOfMemoryError("超出最大容量")
        val newCapacity = minOf(queue.size.toLong() * 2, Int.MAX_VALUE.toLong()).toInt()
        queue = queue.copyOf(newCapacity)
    }
}

fun main() {
    PriorityQueue().apply {
        offer(1)
        offer(12)
        offer(0)
        println(peek())
        offer(7)
        offer(6)
        println(poll())
        println(poll())
        println(poll())
        println(peek())
        println(poll())
    }
}