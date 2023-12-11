fun main() {
    val n = readInt()

    repeat(n) {
        val (m, nth) = readInts()
        val comparator = compareBy<Int> { it }.reversed()
        val pQueue = java.util.PriorityQueue(comparator)

        val queue = java.util.LinkedList(readInts().withIndex().toList())

        for (p in queue) {
            pQueue.add(p.value)
        }

        var cnt = 0
        var flg = false
        while (!flg) {
            val currentP = pQueue.remove()

            while (true) {
                val nxt = queue.remove()
                if (nxt.value == currentP) {
                    cnt += 1
                    if (nxt.index == nth) {
                        flg = true
                    }
                    break
                }
                queue.add(nxt)
            }
        }
        println(cnt)
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }