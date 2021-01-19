package classical

import java.util.*

/**
 * 经典算法 - 快速排序
 * 思路：
 * 1.将第一个元素作为target，通过填坑法，把数组中所有比它小的放到它左边，所有比它大的放到它右边
 * 2.分好之后，将target放在最新出来的坑中，此时，target已经排好位置了
 * 3.整个数组被target分成左右两个部分，通过递归，可以完成对整个数组的排序
 */
fun quickSort(nums: IntArray, left: Int = 0, right: Int = nums.lastIndex) {
    if (left >= right) return
    var (l, r) = left to right
    val target = nums[l]
    while (l < r) {
        while (l < r && nums[r] >= target) r--
        if (l < r) nums[l++] = nums[r]
        while (l < r && nums[l] < target) l++
        if (l < r) nums[r--] = nums[l]
    }
    nums[l] = target
    quickSort(nums, left, l - 1)
    quickSort(nums, l + 1, right)
}

fun <T> quickSort(arr: Array<T>, left: Int = 0, right: Int = arr.size - 1, comparator: Comparator<T>) {
    if (left >= right) return
    var (l, r) = left to right
    val target = arr[l]
    while (l < r) {
        while (l < r && comparator.compare(arr[r], target) >= 0) r--
        if (l < r) arr[l++] = arr[r]
        while (l < r && comparator.compare(arr[l], target) < 0) l++
        if (l < r) arr[r--] = arr[l]
    }
    arr[l] = target
    quickSort(arr, left, l - 1, comparator)
    quickSort(arr, l + 1, right, comparator)
}

fun <T : Comparable<T>> quickSort(arr: Array<T>, left: Int = 0, right: Int = arr.size - 1) {
    if (left >= right) return
    var (l, r) = left to right
    val target = arr[l]
    while (l < r) {
        while (l < r && arr[r] >= target) r--
        if (l < r) arr[l++] = arr[r]
        while (l < r && arr[r] < target) l++
        if (l < r) arr[r--] = arr[l]
    }
    arr[l] = target
    quickSort(arr, left, l - 1)
    quickSort(arr, l + 1, right)
}

fun main() {
    repeat(5) {
        val random = Random()
        val nums = Array(random.nextInt(12) + 8) {
            random.nextInt(100)
        }
        println(nums.contentToString())
        quickSort(nums) { a, b -> b - a }
        println(nums.contentToString())
        println()
    }
}
