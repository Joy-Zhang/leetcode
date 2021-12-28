package zhangyijun03.leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    val l42 = L42()
    println(l42.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(l42.trap(intArrayOf(4, 2, 0, 3, 2, 5)))
}

class L42 {
    fun trap(height: IntArray): Int {
        var topWall = Pair(0, height[0])
        val watermark = IntArray(height.size) { 0 }
        watermark[0] = height[0]
        for (i in 1 until height.size) {
            if (height[i] == 0) {
                continue
            }

            val watermarkNew = min(topWall.second, height[i])
            for (j in topWall.first until i) {
                if (watermark[j] < watermarkNew) {
                    watermark[j] = watermarkNew
                }
            }

            if (height[i] > topWall.second) {
                topWall = Pair(i, height[i])
            }
        }

        return watermark.mapIndexed { index, w -> max(w - height[index], 0) }.sum()
    }
}