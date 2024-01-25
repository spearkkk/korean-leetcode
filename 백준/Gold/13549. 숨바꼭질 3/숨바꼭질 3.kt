fun main() {
    fun isAvailable(cur: Int): Boolean {
        return cur in 0 .. 100_000
    }

    val (n, k) = readInts()

    val queue = java.util.PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second })
    queue.add(Pair(n, 0))

    val visited = BooleanArray(100_000 + 1)

    /**
     * 핵심은 순간이동할 때 시간이 걸리지 않는다는 점이다.
     * 시간이 걸리지 않는다는 것은 시간이 걸리는 이동보다 먼저 작업해야 한다.
     * 이는 결국에 우선 순위 큐를 써야 한다.
     * 
     * 범위 체크를 잘못해서 삽질을 조금 했는데,
     * 결과적으로 우선 순위로 쉽게 풀 수 있는 문제였다. 
     */

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