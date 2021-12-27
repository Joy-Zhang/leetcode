package zhangyijun03.leetcode

fun main(args : Array<String>) {
    val l3 = L3()
    println(l3.lengthOfLongestSubstring("abcabcbb"))
    println(l3.lengthOfLongestSubstring("bbbbb"))
    println(l3.lengthOfLongestSubstring("pwwkew"))
}

class L3 {

    fun lengthOfLongestSubstring(s: String): Int {

        val lengths = Array(s.length) { 0 }
        val repeateds = Array(s.length) { false }
        val strs = Array(s.length) { "" }
        for (i in s.indices) {
            for (j in 0 until i) {
                if (!repeateds[j]) {
                    if (strs[j].contains(s[i])) {
                        repeateds[j] = true
                    } else {
                        lengths[j] += 1
                        strs[j] = strs[j] + s[i]
                    }
                }
            }
            lengths[i] = 1
            strs[i] = strs[i] + s[i]

            // println(lengths.toList())
            // println(repeateds.toList())
            // println(strs.toList())
        }
        var max = 0
        for (i in lengths.indices) {
            if (lengths[i] > max) {
                max = lengths[i]
            }
        }
        return max
    }

}