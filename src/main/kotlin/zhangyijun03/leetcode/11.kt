package zhangyijun03.leetcode

import kotlin.math.min

fun main() {
    println(L11().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
    println(L11().maxArea(intArrayOf(1,1)))
}

class L11 {
    fun maxArea(height: IntArray): Int {

        val usefulHeight = ArrayList<Pair<Int, Int>>(height.size)

        var area = 0
        for (i in height.indices) {
            if (usefulHeight.size <= 0) {
                usefulHeight.add(Pair(i, height[i]))
            } else if (usefulHeight.size == 1) {
                area = min(height[i], usefulHeight[0].second)
                usefulHeight.add(Pair(i, height[i]))
            } else {
                for (j in usefulHeight.indices) {
                    val newArea = min(height[i], usefulHeight[j].second) * (i - usefulHeight[j].first)
                    if (newArea > area) {
                        area = newArea
                    }
                }
                if (height[i] > usefulHeight.last().second) {
                    usefulHeight.add(Pair(i, height[i]))
                }
            }
        }

        return area
    }
}