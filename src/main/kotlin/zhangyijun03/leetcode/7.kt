package zhangyijun03.leetcode

fun main() {
    println(L7().reverse(-2143847412))
    println(L7().reverse(123))
    println(L7().reverse(-123))
    println(L7().reverse(-1234))
    println(L7().reverse(120))
}

class L7 {

    private fun toDigitsList(x: Int): List<Int> {
        var xo = x

        val digits = ArrayList<Int>()
        while (xo != 0) {
            digits.add(xo % 10)
            xo /= 10
        }
        return digits
    }

    fun reverse(x: Int): Int {

        var result = 0
        val digits = toDigitsList(x)
        val maxDigits = toDigitsList(Int.MAX_VALUE).asReversed()
        val minDigits = toDigitsList(Int.MIN_VALUE).asReversed()


        if (digits.size > maxDigits.size) {
            return 0
        } else if (digits.size == maxDigits.size) {
            for (i in digits.indices) {
                if (digits[i] > maxDigits[i] || digits[i] < minDigits[i]) {
                    return 0
                }
            }
        }

        for (i in digits.indices) {
            result = result * 10 + digits[i]
        }


        return result
    }
}