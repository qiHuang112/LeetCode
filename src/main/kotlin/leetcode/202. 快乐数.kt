package leetcode

/*
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 True ；不是，则返回 False 。

示例：
输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/happy-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 暴力求解
 */
private fun isHappy(n: Int): Boolean {
    val set = mutableSetOf<Int>()
    var temp = n
    while (set.add(temp)) {
        temp = getNext(temp)
    }
    return temp == 1
}
/*
1,7,10,13,19,23,28,31,32,44,49,68,70,79,82,86,91,94,97,100
 */
private fun getNext(n: Int): Int {
    var temp = n
    var res = 0
    while (temp != 0) {
        res += (temp % 10) * (temp % 10)
        temp /= 10
    }
    return res
}

/**
 * 将一个个数看成链表的一个个节点，也可以用快慢指针解决，就不用哈希表了
 */
fun main() {
    for (i in 1..100) {
        isHappy(i)
    }
}