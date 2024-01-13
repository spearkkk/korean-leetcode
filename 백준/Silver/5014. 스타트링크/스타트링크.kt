fun main() {
    val (f, s, g, u, d) = readInts()

    val visited = BooleanArray(f + 1)

    val queue = arrayListOf(s)
    val anotherQueue = arrayListOf<Int>()

    var cnt = 0
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
            cnt += 1

            queue.addAll(anotherQueue)
            anotherQueue.clear()
        }

        val cur = queue.removeFirst()
        if (cur == g) {
            println(cnt)
            return
        }

        if (visited[cur]) {
            continue
        }

        visited[cur] = true
        if (cur + u <= f) {
            anotherQueue.add(cur + u)
        }

        if (cur - d > 0) {
            anotherQueue.add(cur - d)
        }
    }
    println("use the stairs")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }