package leetcode

/*
给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。

注意:
输入只包含小写英文字母。
输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
输入字符串的长度小于 50,000。

示例 1:
输入: "owoztneoer"
输出: "012" (zeroonetwo)

示例 2:
输入: "fviefuro"
输出: "45" (fourfive)

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * zero count(z)
 * one count(o) - count(zero) - count(two) - count(four)
 * two count(w)
 * three count(h) - count(eight)
 * four count(f) - count(five)
 * five count(v) - count(seven)
 * six count(x)
 * seven count(s) - count(six)
 * eight count(g)
 * nine count(i) - count(five) - count(six) - count(eight)
 */
private fun originalDigits(s: String): String {
    val map = IntArray(26)
    for (c in s) {
        map[c - 'a']++
    }
    val count = IntArray(10)
    count[0] = map['z' - 'a']
    count[2] = map['w' - 'a']
    count[6] = map['x' - 'a']
    count[7] = map['s' - 'a'] - count[6]
    count[5] = map['v' - 'a'] - count[7]
    count[4] = map['f' - 'a'] - count[5]
    count[8] = map['g' - 'a']
    count[3] = map['h' - 'a'] - count[8]
    count[1] = map['o' - 'a'] - count[0] - count[2] - count[4]
    count[9] = map['i' - 'a'] - count[5] - count[6] - count[8]
    return (0..9).joinToString("") { num -> (0 until count[num]).joinToString("") { "$num" } }
}

fun main() {
    println(originalDigits("owoztneoer"))
    println(originalDigits("fviefuro"))
}