fun main() {
    val (n, k) = readInts()

    val queue = arrayListOf<Int>()
    queue.add(n)

    val visited = BooleanArray(100_000 + 1)
    var cnt = 0
    while (queue.isNotEmpty()) {
        val anotherQueue = queue.toMutableList()
        queue.clear()
        while (anotherQueue.isNotEmpty()) {
            val cur = anotherQueue.removeFirst()
            if (visited[cur]) {
                continue
            }
            visited[cur] = true

            if (cur == k) {
                println(cnt)
                return
            }

            if (cur - 1 >= 0) {
                queue.add(cur - 1)
            }
            if (cur + 1 <= 100_000) {
                queue.add(cur + 1)
            }
            if (cur * 2 <= 100_000) {
                queue.add(cur * 2)
            }
        }

        cnt += 1
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }