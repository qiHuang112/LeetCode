package classical

/**
 * 思路：
 * 1.分为两组
 * 2.合并
 */
fun mergeSort(nums: IntArray) {
    if (nums.size <= 1) return
    val left = nums.copyOfRange(0, nums.size / 2).apply(::mergeSort)
    val right = nums.copyOfRange(nums.size / 2, nums.size).apply(::mergeSort)
    var (i, j) = 0 to 0
    while (i < left.size || j < right.size) {
        when {
            i == left.size -> nums[i + j] = right[j++]
            j == right.size -> nums[i + j] = left[i++]
            left[i] < right[j] -> nums[i + j] = left[i++]
            else -> nums[i + j] = right[j++]
        }
    }
}


fun main() {
    val arr = intArrayOf(5, 88, 45, 37, 91, 26, 13, 66, 50)
    mergeSort(arr)
    println(arr.contentToString())
}