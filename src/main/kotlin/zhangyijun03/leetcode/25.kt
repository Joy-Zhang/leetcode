package zhangyijun03.leetcode


fun main() {
    val l25 = L25()
    println(l25.reverseKGroup(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }, 2))
    println(l25.reverseKGroup(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 2))

    println(l25.reverseKGroup(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 3))
}

class L25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var op0 = head
        var op1 = head?.next
        var op2 = head?.next?.next
        var opGroupTail: ListNode? = op0
        var currentGroupTail: ListNode? = null
        var lastGroupTail: ListNode? = null
        var reversedCount = 1
        var result: ListNode? = null

        for (i in 0 until k - 1) {
            opGroupTail = opGroupTail?.next
        }

        if (opGroupTail == null) {
            return head
        }


        while (op0 != null) {
            if (reversedCount == 1) {
                currentGroupTail = op0
            }

            if (reversedCount == k) {
                reversedCount = 0
                lastGroupTail?.next = op0
                lastGroupTail = currentGroupTail
                if (result == null) {
                    result = op0
                }
                opGroupTail = op1
                for (i in 0 until k - 1) {
                    opGroupTail = opGroupTail?.next
                }
                if (opGroupTail == null) {
                    lastGroupTail?.next = op1
                    break
                }

            } else {
                op1?.next = op0
            }

            if (op1 == null) {
                lastGroupTail?.next = op0
            }

            reversedCount++
            op0 = op1
            op1 = op2
            op2 = op2?.next
        }
        return result ?: head
    }
}