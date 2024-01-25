fun main() {

    fun isAvailable(cur: Int): Boolean {
        return cur in 0 .. 100_000
    }

    val (n, k) = readInts()

    val queue = java.util.PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second })
    queue.add(Pair(n, 0))

    val visited = BooleanArray(100_000 + 1)

    while (queue.isNotEmpty()) {
        val (cur, cnt) = queue.remove()
        if (cur == k) {
            println(cnt)
            return
        }

        if (visited[cur]) {
            continue
        }

        visited[cur] = true

        if (isAvailable(cur - 1)) {
            queue.add(Pair(cur - 1, cnt + 1))
        }
        if (isAvailable(cur + 1)) {
            queue.add(Pair(cur + 1, cnt + 1))
        }
        if (isAvailable(cur * 2)) {
            queue.add(Pair(cur * 2, cnt))
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