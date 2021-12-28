package zhangyijun03.leetcode

import java.util.Comparator
import java.util.PriorityQueue

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    L23().mergeKLists(arrayOf(
        ListNode(-2).apply {
           next = ListNode(-1).apply {
                next = ListNode(-1).apply {
                    next = ListNode(-1)
                }
           }
        },
        null
    ))
}

class L23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val minHeap = PriorityQueue(Comparator<ListNode> { p0, p1 -> p0.`val` - p1.`val`})

        for (l in lists) {
            var op = l
            while (op != null) {
                minHeap.add(op)
                op = op.next
            }
        }

        val head = minHeap.poll()

        var o = head
        while (minHeap.isNotEmpty()) {
            o?.next = minHeap.poll()
            o = o?.next
        }
        o?.next = null
        return head
    }
}