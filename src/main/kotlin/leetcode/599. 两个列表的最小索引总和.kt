package leetcode

/*
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。

示例 1:
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。

示例 2:
输入:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
提示:

两个列表的长度范围都在 [1, 1000]内。
两个列表中的字符串的长度将在[1，30]的范围内。
下标从0开始，到列表的长度减1。
两个列表都没有重复的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    var minIndex = list1.size + list2.size
    val res = mutableListOf<String>()
    val map = hashMapOf<String, Int>()
    for (i in list1.indices) {
        map[list1[i]] = i
    }
    for (i in list2.indices) {
        map[list2[i]]?.let {
            when {
                minIndex > it + i -> {
                    minIndex = it + i
                    res.clear()
                    res.add(list2[i])
                }
                minIndex == it + i -> {
                    res.add(list2[i])
                }
                else -> Unit
            }
        }
    }
    return res.toTypedArray()
}

fun main() {
    println(
        findRestaurant(
            arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
            arrayOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")
        ).contentToString()
    )
    println(
        findRestaurant(
            arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
            arrayOf("KFC", "Shogun", "Burger King")
        ).contentToString()
    )
}