package leetcode

/*
给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
注意：请不要在超过该数组长度的位置写入元素。
要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。

示例 1：
输入：[1,0,2,3,0,4,5,0]
输出：null
解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]

示例 2：
输入：[1,2,3]
输出：null
解释：调用函数后，输入的数组将被修改为：[1,2,3]

提示：
1 <= arr.length <= 10000
0 <= arr[i] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/duplicate-zeros
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun duplicateZeros(arr: IntArray): Unit {
    val temp = IntArray(arr.size)
    var i = 0
    var j = 0
    while (i < arr.size) {
        temp[i++] = arr[j++]
        if (i < arr.size && arr[j - 1] == 0) {
            temp[i++] = 0
        }
    }
    for (k in temp.indices) {
        arr[k] = temp[k]
    }
}

fun main() {
    println(intArrayOf(1, 0, 2, 3, 0, 4, 5, 0).apply(::duplicateZeros).let(IntArray::contentToString))
    println(intArrayOf(1, 2, 3).apply(::duplicateZeros).let(IntArray::contentToString))
    println(intArrayOf(0, 0, 0).apply(::duplicateZeros).let(IntArray::contentToString))
    println(intArrayOf(8, 4, 5, 0, 0, 0, 0, 7).apply(::duplicateZeros).let(IntArray::contentToString))
}
/*
1, 0, 2, 3, 0, 4, 5, 0

 */