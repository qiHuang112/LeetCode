package leetcode

/*
给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]

示例 1：
输入："IDID"
输出：[0,4,1,3,2]

示例 2：
输入："III"
输出：[0,1,2,3]

示例 3：
输入："DDI"
输出：[3,2,0,1]
 
提示：
1 <= S.length <= 10000
S 只包含字符 "I" 或 "D"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-string-match
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun diStringMatch(S: String): IntArray {
    val offset = S.count { it == 'D' }
    val res = IntArray(S.length + 1)
    var index = 0
    res[index++] = offset
    var left = offset - 1
    var right = offset + 1
    for (c in S) {
        when (c) {
            'I' -> res[index++] = right++
            'D' -> res[index++] = left--
        }
    }
    return res
}

fun main() {
    println(diStringMatch("IDID").contentToString())
    println(diStringMatch("III").contentToString())
    println(diStringMatch("DDD").contentToString())
    println(diStringMatch("DDI").contentToString())
}
/*
IDID:01234
从2开始
2 3 1 4 0

III:0123
从0开始
0 1 2 3

DDD:0123
从3开始
3 2 1 0

DDI:0123
从2开始
2 1 0 3

 */