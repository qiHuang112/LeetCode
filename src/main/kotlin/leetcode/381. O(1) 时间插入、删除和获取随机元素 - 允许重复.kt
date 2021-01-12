package leetcode

import java.util.*
import kotlin.random.Random


/*
设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。

注意: 允许出现重复元素。

insert(val)：向集合中插入元素 val。
remove(val)：当 val 存在时，从集合中移除一个 val。
getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。

示例:
// 初始化一个空的集合。
RandomizedCollection collection = new RandomizedCollection();

// 向集合中插入 1 。返回 true 表示集合不包含 1 。
collection.insert(1);

// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
collection.insert(1);

// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
collection.insert(2);

// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
collection.getRandom();

// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
collection.remove(1);

// getRandom 应有相同概率返回 1 和 2 。
collection.getRandom();

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private class RandomizedCollection() {

    val map = mutableMapOf<Int, LinkedList<Int>>()
    val nums = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (map[`val`] == null) {
            map[`val`] = LinkedList()
        }
        val list = map[`val`]!!
        nums.add(`val`)
        list.add(nums.size - 1)
        return list.size == 1
    }

    fun remove(`val`: Int): Boolean {
        val list = map[`val`]
        if (list == null || list.size == 0) return false
        val index = list.remove()
        val temp = nums[nums.lastIndex]
        nums[nums.lastIndex] = nums[index]
        nums[index] = temp

        val last = map[temp]!!
        for (i in last.indices) {
            if (last[i] == nums.lastIndex) {
                last[i] = index
                break
            }
        }
        nums.removeAt(nums.lastIndex)
        return true
    }

    fun getRandom(): Int {
        return nums[Random.nextInt(0, nums.size)]
    }

}

fun main() {
    RandomizedCollection().apply {
        insert(0).let(::println) // true -> 0
        insert(1).let(::println) // true -> 0,1
        remove(0).let(::println) // true -> 1
        insert(2).let(::println) // true -> 1,2
        remove(1).let(::println) // true -> 2
        getRandom().let(::println) // 2
    }
//    RandomizedCollection().apply {
//        insert(1).let(::println) // true -> 1
//        insert(1).let(::println) // false -> 1,1
//        insert(2).let(::println) // true -> 1,1,2
//        getRandom().let(::println) // 1 1 2 选一个
//        remove(1).let(::println) // true -> 1,2
//        getRandom().let(::println) // 1,2 选一个
//    }
}