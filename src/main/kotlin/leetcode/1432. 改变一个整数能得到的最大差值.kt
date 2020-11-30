package leetcode

/*
给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：

选择一个数字 x (0 <= x <= 9).
选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
将 num 中所有出现 x 的数位都用 y 替换。
得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
令两次对 num 的操作得到的结果分别为 a 和 b 。

请你返回 a 和 b 的 最大差值 。

123456
923456
103456

10000
90000
10000

9288
9988
1288

5566
9966
1166
 */
private fun maxDiff(num: Int): Int {
    val replace = { arr: CharArray, from: Char, to: Char ->
        arr.forEachIndexed { i, c ->
            if (c == from) {
                arr[i] = to
            }
        }
        arr
    }

    // 从首位开始往后找，直到找到一个不是'9'的，将arr中所有这个数换成'9'
    val getMax = { arr: CharArray ->
        val index = arr.indexOfFirst { it != '9' }
        if (index in arr.indices) {
            replace(arr, arr[index], '9')
        }
        String(arr).toInt().also(::println)
    }

    // 从首位开始找，如果第一位不是1，将首位改成1
    // 首位是1，找一位 改成0
    val getMin = { arr: CharArray ->
        if (arr[0] != '1') {
            replace(arr, arr[0], '1')
        } else {
            val index = arr.indexOfFirst { it != '0' && it != '1' }
            if (index in arr.indices) {
                replace(arr, arr[index], '0')
            }
        }
        String(arr).toInt().also(::println)
    }
    return getMax(num.toString().toCharArray()) - getMin(num.toString().toCharArray())

}

fun main() {
    println(maxDiff(123456))
    println(maxDiff(5566))
}