fun main() {
    fun isAvailable(cur: Int): Boolean {
        return cur in 0 .. 200_000
    }

    val (n, k) = readInts()

    val queue = java.util.PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    queue.add(Pair(n, 0))

    val visited = IntArray(200_000 + 1) { -1 }

    while (queue.isNotEmpty()) {
        val (cur, cnt) = queue.remove()
        if (cur == k) {
            println(cnt)

            val deque = java.util.ArrayDeque<Int>()
            var cursor = k
            while (cursor != n) {
                deque.addFirst(cursor)
                cursor = visited[cursor]
            }
            deque.addFirst(n)
            println(deque.joinToString(" "))

            return
        }

        if (isAvailable(cur - 1) && visited[cur - 1] == -1) {
            visited[cur - 1] = cur
            queue.add(Pair(cur - 1, cnt + 1))
        }
        if (cur > k) {
            continue
        }
        if (isAvailable(cur + 1) && visited[cur + 1] == -1) {
            visited[cur + 1] = cur
            queue.add(Pair(cur + 1, cnt + 1))
        }
        if (isAvailable(cur * 2) && visited[cur * 2] == -1) {
            visited[cur * 2] = cur
            queue.add(Pair(cur * 2, cnt + 1))
        }
    }
    println(-1)
}

fun readStr() = readln()

fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }