package zhangyijun03.leetcode

fun main() {
    val l12 = L12()
    println(l12.intToRoman(3))
    println(l12.intToRoman(58))
    println(l12.intToRoman(1994))
}

class L12 {


    fun intToRoman(num: Int): String {
        val romanTable = mapOf(
            3000 to "MMM",
            2000 to "MM",
            1000 to "M",
            900 to "CM",
            800 to "DCCC",
            700 to "DCC",
            600 to "DC",
            500 to "D",
            400 to "CD",
            300 to "CCC",
            200 to "CC",
            100 to "C",
            90 to "XC",
            80 to "LXXX",
            70 to "LXX",
            60 to "LX",
            50 to "L",
            40 to "XL",
            30 to "XXX",
            20 to "XX",
            10 to "X",
            9 to "IX",
            8 to "VIII",
            7 to "VII",
            6 to "VI",
            5 to "V",
            4 to "IV",
            3 to "III",
            2 to "II",
            1 to "I",
            0 to ""
        )
        val sb = StringBuilder()
        if (num >= 1000) {
            sb.append(romanTable[(num % 10000) - (num % 1000)])
        }
        if (num >= 100) {
            sb.append(romanTable[(num % 1000) - (num % 100)])
        }
        if (num >= 10) {
            sb.append(romanTable[(num % 100) - (num % 10)])
        }
        sb.append(romanTable[(num % 10)])
        return sb.toString()
    }
}