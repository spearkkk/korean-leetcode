fun main() {
    val dirY = intArrayOf(1, 0, -1, 0, 0, 0)
    val dirX = intArrayOf(0, 1, 0, -1, 0, 0)
    val dirZ = intArrayOf(0, 0, 0, 0, 1, -1)

    val (m, n, h) = readInts()
    val mat = Array(h) { Array(n) { IntArray(m) } }

    val queue = java.util.LinkedList<Pair<Int, Pair<Int, Int>>>()

    for (z in 0 until h) {
        for (y in 0 until n) {
            mat[z][y] = readInts().toIntArray()

            for (x in 0 until m) {
                if (mat[z][y][x] == 1) {
                    // red tomato
                    queue.add(Pair(z, Pair(y, x)))
                }
            }
        }
    }


    val visited = Array(h) { Array(n) { BooleanArray(m) } }
    val anotherQueue = mutableSetOf<Pair<Int, Pair<Int, Int>>>()

    var cnt = 0

    // dfs
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
            // 현재 스테이지의 위치는 다 처리함
            for (elem in anotherQueue) {
                val (z, point) = elem
                val (y, x) = point
                if (mat[z][y][x] == 1) {
                    // 이미 익었다.
                    continue
                }
                queue.add(elem)
            }

            if (queue.isEmpty()) {
                // 다음 스테이지로 갈 수 있는 토마토가 없다
                break
            }

            anotherQueue.clear()
            cnt += 1
        }

        val (z, point) = queue.removeFirst()
        val (y, x) = point

        if (visited[z][y][x]) {
            continue
        }

        visited[z][y][x] = true
        mat[z][y][x] = 1

        for (i in 0 until 6) {
            val nz = z + dirZ[i]
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (nz < 0 || nz >= h || ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue
            }

            if (visited[nz][ny][nx] || mat[nz][ny][nx] == 1 || mat[nz][ny][nx] == -1) {
                continue
            }

            anotherQueue.add(Pair(nz, Pair(ny, nx)))
        }
    }

    for (z in 0 until h) {
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (mat[z][y][x] == 0) {
                    println(-1)
                    return
                }
            }
        }
    }

    println(cnt)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }