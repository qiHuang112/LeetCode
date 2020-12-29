package leetcode

/*
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
你可以按任意顺序返回答案。

示例 1：
输入：["bella","label","roller"]
输出：["e","l","l"]

示例 2：
输入：["cool","lock","cook"]
输出：["c","o"]

提示：
1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-common-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun commonChars(A: Array<String>): List<String> {
    val arr = A.map(::stringToMap).reduce(::common)
    val res = mutableListOf<String>()
    for (i in arr.indices) {
        for (j in 1..arr[i]) {
            res.add("${'a' + i}")
        }
    }
    return res
}

private fun common(arr1: IntArray, arr2: IntArray): IntArray {
    for (i in 0..25) {
        arr1[i] = minOf(arr1[i], arr2[i])
    }
    return arr1
}

private fun stringToMap(s: String): IntArray {
    val map = IntArray(26)
    for (c in s) {
        map[c - 'a']++
    }
    return map
}

fun main() {
    println(commonChars(arrayOf("bella", "label", "roller")))
    println(commonChars(arrayOf("cool", "lock", "cook")))
}