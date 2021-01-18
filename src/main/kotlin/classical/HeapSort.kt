package classical

/**
 * 经典算法 - 堆排序
 * 思路:
 * 1.将整个数组初始化为一个大顶堆
 * 2.将顶点元素和最后一个元素互换位置，得到一个最小的数和两个大顶堆
 * 3.此时最后一个数已经排列好,循环n次
 */
fun heapSort(nums: IntArray) {
    val swap = { i: Int, j: Int -> nums[i] = nums[j].also { nums[j] = nums[i] } }

    // 向下调整
    fun sift(index: Int, size: Int) {
        var parent = index
        var child = parent * 2 + 1
        val target = nums[parent]
        while (child < size) {
            if (child + 1 < size && nums[child + 1] > nums[child]) child++
            if (nums[child] <= target) break
            nums[parent] = nums[child]
            parent = child
            child = parent * 2 + 1
        }
        nums[parent] = target
    }

    // 建立大顶堆
    for (i in nums.size / 2 - 1 downTo 0) {
        sift(i, nums.size)
    }

    // 堆排序
    for (i in nums.lastIndex downTo 0) {
        swap(0, i)
        sift(0, i)
    }
}

fun main() {
//    val nums = intArrayOf(16, 7, 3, 20, 17, 8)
    val nums = intArrayOf(5, 88, 45, 37, 91, 26, 13, 66, 50)
    heapSort(nums)
    println(nums.contentToString())
}
