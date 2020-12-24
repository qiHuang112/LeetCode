package leetcode

import java.util.*

/*
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。

示例 1：
输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]

示例 2：
输入：s = "0000"
输出：["0.0.0.0"]

示例 3：
输入：s = "1111"
输出：["1.1.1.1"]

示例 4：
输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]

示例 5：
输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 
提示：
0 <= s.length <= 3000
s 仅由数字组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * dfs
 */
private fun restoreIpAddresses(s: String): List<String> {
    val res = mutableListOf<String>()
    dfs(res, s.toCharArray(), 0, LinkedList())
    return res
}

private fun dfs(res: MutableList<String>, arr: CharArray, index: Int, temp: LinkedList<String>) {
    if (temp.size == 4) {
        if (index == arr.size) {
            res.add(temp.joinToString(".") { it })
        }
        return
    }
    for (i in 1..3) {
        if (index + i <= arr.size) {
            val cur = String(arr, index, i)
            if (cur.length > 1 && cur[0] == '0') continue
            if (cur.toInt() < 256) {
                temp.addLast(cur)
                dfs(res, arr, index + i, temp)
                temp.removeLast()
            }
        }
    }
}

fun main() {
    println(restoreIpAddresses("25525511135"))
    println(restoreIpAddresses("0000"))
    println(restoreIpAddresses("1111"))
    println(restoreIpAddresses("010010"))
    println(restoreIpAddresses("101023"))
}