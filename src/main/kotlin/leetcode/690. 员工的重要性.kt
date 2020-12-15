package leetcode

/*
给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。

示例 1:
输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
输出: 11
解释:
员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。

注意:
一个员工最多有一个直系领导，但是可以有多个直系下属
员工数量不超过2000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/employee-importance
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List<Int> = listOf()
}

/**
 * 递归
 */
private fun getImportance1(employees: List<Employee?>, id: Int): Int {
    val root = employees.find { it?.id == id }
    var res = 0
    root?.let {
        res += it.importance
        it.subordinates.forEach { subId ->
            res += getImportance(employees, subId)
        }
    }
    return res
}

/**
 * 哈希表存id，避免查找
 */
private fun getImportance(employees: List<Employee?>, id: Int): Int {
    val hashMap = employees.fold(mutableMapOf<Int, Employee>()) { acc, employee ->
        employee?.let { acc[it.id] = it }
        acc
    }

    fun getRes(id: Int): Int {
        var res = 0
        hashMap[id]?.let {
            res += it.importance
            it.subordinates.forEach { subId ->
                res += getRes(subId)
            }
        }
        return res
    }
    return getRes(id)
}

fun main() {
    println(
        getImportance(
            listOf(
                Employee().apply {
                    id = 1
                    importance = 5
                    subordinates = listOf(2, 3)
                },
                Employee().apply {
                    id = 2
                    importance = 3
                },
                Employee().apply {
                    id = 3
                    importance = 3
                },
            ), 1
        )
    )
}