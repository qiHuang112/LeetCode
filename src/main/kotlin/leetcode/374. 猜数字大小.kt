package leetcode

/*
猜数字游戏的规则如下：
每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

-1：我选出的数字比你猜的数字小 pick < num
1：我选出的数字比你猜的数字大 pick > num
0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num

示例 1：
输入：n = 10, pick = 6
输出：6

示例 2：
输入：n = 1, pick = 1
输出：1

示例 3：
输入：n = 2, pick = 1
输出：1

示例 4：
输入：n = 2, pick = 2
输出：2
 
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private abstract class GuessGame {
    var pick = 10
    abstract fun guessNumber(n: Int): Int
    fun guess(n: Int) = when {
        pick > n -> 1
        pick < n -> -1
        else -> 0
    }
}

private class Solution : GuessGame() {
    override fun guessNumber(n: Int): Int {
        var (left, right) = 1 to n
        while (left < right) {
            val mid = (right - left) / 2 + left
            when (guess(mid)) {
                0 -> return mid
                -1 -> right = mid - 1
                1 -> left = mid + 1
            }
        }
        return left
    }
}

fun main() {
    Solution().apply {
        pick = 1
        println(guessNumber(30))
    }
}