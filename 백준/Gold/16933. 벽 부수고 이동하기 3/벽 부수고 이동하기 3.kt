fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    fun isAvailable(y: Int, x: Int, n: Int, m: Int): Boolean {
        return y in 0 until n && x in 0 until m
    }

    val (n, m, k) = readInts()

    val mat = Array(n) { IntArray(m) }
    for (y in 0 until n) {
        val tmp = readStr()
        for (x in 0 until m) {
            mat[y][x] = tmp[x].code - '0'.code
        }
    }

    // Point: ((y, x) -> k) -> isDay
    val queue = java.util.ArrayDeque<Point>()

    val visited = Array(n) { Array(m) { BooleanArray(k + 1) } }

    // initialize first point (1, 1)
    queue.add(Pair(Pair(Pair(Pair(0, 0), 0), true), 1))

    // bfs
    while (queue.isNotEmpty()) {
//        println(queue.joinToString(" "))

        val point = queue.removeFirst()
        val (tmp, cnt) = point
        val (tmp1, isDay) = tmp
        val (tmp2, hasK) = tmp1
        val (y, x) = tmp2

        if (y == n - 1 && x == m - 1) {
            println(cnt)
            return
        }

//        println("y: $y, x: $x, hasK: $hasK, isDay: $isDay")
        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx, n, m)) {
                continue
            }

            if (mat[ny][nx] == 0) {
//                println("ny: $ny, nx: $nx, hasK: $hasK, isDay: $isDay, mat[ny][nx]: ${mat[ny][nx]}")
                if (visited[ny][nx][hasK]) {
                    continue
                }
                visited[ny][nx][hasK] = true
                queue.add(Pair(Pair(Pair(Pair(ny, nx), hasK), !isDay), cnt + 1))
            } else {
//                println("ny: $ny, nx: $nx, hasK: $hasK, isDay: $isDay, mat[ny][nx]: ${mat[ny][nx]}")
                if (hasK < k) {
                    if (visited[ny][nx][hasK + 1]) {
                        continue
                    }

                    if (isDay) {
                        visited[ny][nx][hasK + 1] = true
                        queue.add(Pair(Pair(Pair(Pair(ny, nx), hasK + 1), false), cnt + 1))
                    } else {
                        queue.add(Pair(Pair(Pair(Pair(y, x), hasK), true), cnt + 1))
                    }
                }
            }
        }
    }

    println(-1)
}

typealias Point = Pair<Pair<Pair<Pair<Int, Int>, Int>, Boolean>, Int>

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }