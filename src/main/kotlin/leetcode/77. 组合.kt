package leetcode

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * 普通回溯算法实现组合
 */
private fun combine1(n: Int, k: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    dfs(res, n, k, 1, mutableListOf())
    return res
}

private fun dfs(res: MutableList<List<Int>>, n: Int, k: Int, i: Int, temp: MutableList<Int>) {
    if (temp.size == k) {
        res.add(ArrayList(temp))
        return
    }
    if (i > n) return
    dfs(res, n, k, i + 1, temp)
    temp.add(i)
    dfs(res, n, k, i + 1, temp)
    temp.removeAt(temp.lastIndex)
}

/**
 * 非递归，字典序实现组合
 */
private fun combine(n: Int, k: Int): List<List<Int>> {
    val temp = MutableList(k) { it + 1 }
    temp.add(n + 1)
    val res = mutableListOf<List<Int>>()
    var i = 0
    while (i < k) {
        res.add(ArrayList(temp.subList(0, k)))
        i = 0
        while (i < k && temp[i] + 1 == temp[i + 1]) {
            temp[i] = i + 1
            i++
        }
        temp[i] = temp[i] + 1
    }
    return res
}

fun main() {
    println(combine(4, 2))
//    println(combine(5, 3))
}