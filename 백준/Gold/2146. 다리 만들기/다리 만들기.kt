fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val n = readInt()
    val m = n

    fun isAvailable(y: Int, x: Int): Boolean {
        return y in 0 until n && x in 0 until m
    }

    val mat = Array(n) { IntArray(m) }

    // initialize
    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
    }

    val queue = java.util.LinkedList<Pair<Pair<Int, Int>, Int>>()
    val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Int>>()
    val visited = Array(n) { BooleanArray(m) }

    // 이미 육지를 주어진 mark 값으로 채운다.
    // 육지 별로 서로 다른 마킹
    fun dfs(y: Int, x: Int, mark: Int) {
        if (visited[y][x]) {
            return
        }
        if (mat[y][x] == 0) {
            return
        }

        visited[y][x] = true
        mat[y][x] = mark

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx)) {
                continue
            }

            if (mat[ny][nx] == 0) {
                anotherQueue.add(Pair(Pair(ny, nx), mark)) // 현재 육지에 인접한 바다를 넣는다.
                continue
            }
            dfs(ny, nx, mark)
        }
    }

    var mark = 2
    for (y in 0 until n) {
        for(x in 0 until m) {
            if (visited[y][x]) {
                continue
            }

            if (mat[y][x] == 1) {
                dfs(y, x, mark)
                mark += 1
            }
        }
    }

    var cnt = 0
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
            for (elem in anotherQueue) {
                val (point, marked) = elem
                val (y, x) = point

                if (visited[y][x]) {
                    if (mat[y][x] == marked) {
                        continue
                    }
                    println(cnt * 2)
                    return
                }

                queue.add(elem)
            }

            if (queue.isEmpty()) {
                break
            }
            cnt += 1
        }

        val (point, marked) = queue.removeFirst()
        val (y, x) = point

        if (visited[y][x]) {
            if (mat[y][x] != marked) {
                println(cnt * 2 - 1)
                return
            }
            continue
        }
        visited[y][x] = true
        mat[y][x] = marked

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx)) {
                continue
            }

            if (mat[ny][nx] != marked) {
                anotherQueue.add(Pair(Pair(ny, nx), marked))
            }
        }
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }