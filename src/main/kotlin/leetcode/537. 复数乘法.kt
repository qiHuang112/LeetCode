package leetcode

import java.lang.StringBuilder

/*
给定两个表示复数的字符串。

返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。

示例 1:
输入: "1+1i", "1+1i"
输出: "0+2i"
解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。

示例 2:
输入: "1+-1i", "1+-1i"
输出: "0+-2i"
解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。

注意:
输入字符串不包含额外的空格。
输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/complex-number-multiplication
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
private fun complexNumberMultiply1(a: String, b: String): String {
    val (realA, virtualA) = a.split("+")
    val (realB, virtualB) = b.split("+")
    val real = add(multiply(realA, realB), multiply(virtualA, virtualB))
    val virtual = add(multiply(realA, virtualB), multiply(realB, virtualA))
    return "$real+$virtual"
}

private fun multiply(a: String, b: String): String {
    val signA = a[0] != '-'
    val signB = b[0] != '-'
    val realA = a.last() != 'i'
    val realB = b.last() != 'i'
    val sign: Boolean
    val real: Boolean
    // 符号一正一负
    if (signA xor signB) {
        // 类型一虚一实
        if (realA xor realB) {
            sign = false
            real = false
        } else {
            sign = !realA
            real = true
        }
    } else {
        // 类型一虚一实
        if (realA xor realB) {
            sign = true
            real = false
        } else {
            sign = realA
            real = true
        }
    }
    val tempA = a.trim('-').trim('i').toInt()
    val tempB = b.trim('-').trim('i').toInt()
    val sb = StringBuilder()
    sb.append((tempA * tempB))
    if (!sign) {
        sb.insert(0, '-')
    }
    if (!real) {
        sb.append('i')
    }
    return sb.toString()
}

private fun add(a: String, b: String): String {
    val real = a.last() != 'i'
    val tempA = a.trim('i').toInt()
    val tempB = b.trim('i').toInt()
    val sb = StringBuilder()
    sb.append((tempA + tempB))
    if (!real) {
        sb.append('i')
    }
    return sb.toString()
}

private fun complexNumberMultiply(a: String, b: String): String {
    val complexA = stringToComplex(a)
    val complexB = stringToComplex(b)
    val real = complexA.first * complexB.first - complexA.second * complexB.second
    val virtual = complexA.first * complexB.second + complexA.second * complexB.first
    return "$real+${virtual}i"
}

private fun stringToComplex(s: String): Pair<Int, Int> {
    val real: Int
    val virtual: Int
    s.split("+").let {
        real = it[0].toInt()
        virtual = it[1].substring(0, it[1].lastIndex).toInt()
    }
    return real to virtual
}


fun main() {
    println(complexNumberMultiply("1+1i", "1+1i"))
    println(complexNumberMultiply("1+-1i", "1+-1i"))
}