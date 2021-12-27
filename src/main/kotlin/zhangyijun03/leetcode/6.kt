package zhangyijun03.leetcode

fun main() {
    val l6 = L6()

    println(l6.convert("AB", 1))
    println(l6.convert("PAYPALISHIRING", 3))
    println(l6.convert("PAYPALISHIRING", 4))
    println(l6.convert("A", 1))
}

class L6 {
    fun convert(s: String, numRows: Int): String {
        val rows = Array(numRows) { "" }
        var i = 0
        var step = 1
        for (c in s) {
            rows[i] = rows[i] + c

            if (numRows == 1) {
                step = 0
            } else if (i + step == numRows) {
                step = -1
            } else if (i + step < 0) {
                step = 1
            }
            i += step

            // println(rows.toList())
        }

        return rows.joinToString("")
    }
}