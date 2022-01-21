package zhangyijun03.leetcode

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun println(head: ListNode?) {
    var op = head
    while (op != null) {
        print(op.`val`)
        if (op.next != null) {
            print("->")
        }
        op = op.next
    }
    println()
}