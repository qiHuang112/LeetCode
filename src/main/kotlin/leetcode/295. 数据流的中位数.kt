package leetcode

/*
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，
[2,3,4] 的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

示例：
addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

进阶:
如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-median-from-data-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 1.通解：插入排序
 * 2.如果所有整数在0~100之间，可以用一个0~100的Int数组保存每个数的个数，然后找中间的数
 * 3.如果99%在0~100，那么中位数必然在0~100之间，可以维护两个变量分别统计小于0和大于100 的数，然后找中间的数
 *
 * 下面实现插入排序
 */
private class MedianFinder() {

    val nums = mutableListOf<Int>()

    fun addNum(num: Int) {
        if (nums.isEmpty() || num > nums[nums.lastIndex]) {
            nums.add(num)
            return
        }
        if (num < nums[0]) {
            nums.add(0, num)
            return
        }
        var (left, right) = 0 to nums.lastIndex
        while (left < right) {
            val mid = (left + right).ushr(1)
            when {
                num > nums[mid] -> left = mid + 1
                num < nums[mid] -> right = mid
                else -> {
                    nums.add(mid, num)
                    return
                }
            }
        }
        nums.add(right, num)
    }

    fun findMedian(): Double {
        if (nums.size % 2 == 1) return nums[nums.size / 2].toDouble()
        return (nums[nums.size / 2] + nums[nums.size / 2 - 1]) / 2.0
    }

}


fun main() {
    MedianFinder().apply {
        addNum(1)
        addNum(2)
        findMedian().let(::println)
        addNum(3)
        findMedian().let(::println)
    }
}