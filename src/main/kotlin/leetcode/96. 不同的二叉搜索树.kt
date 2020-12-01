package leetcode

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun numTrees(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 1
    // dp[i] = 将i个数分成两组，∑(j从0~i)dp[i - j - 1] * dp[j]
    for (i in 1..n) {
        for (j in 0 until i) {
            dp[i] += dp[j] * dp[i - j - 1]
        }
    }
    return dp[n]
}

fun main() {
    println(numTrees(8))
}