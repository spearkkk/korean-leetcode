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

    // Point: ((y, x) -> k) -> count
    val queue = java.util.ArrayDeque<Point>()

    val visited = Array(n) { Array(m) { BooleanArray(k + 1) } }

    // initialize first point (1, 1)
    queue.add(Pair(Pair(Pair(0, 0), 0), 1))

    // bfs
    while (queue.isNotEmpty()) {
        val point = queue.removeFirst()
        val (tmp1, cnt) = point
        val (tmp2, hasK) = tmp1
        val (y, x) = tmp2

        if (y == n - 1 && x == m - 1) {
            println(cnt)
            return
        }

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx, n, m)) {
                continue
            }

            // 벽이 아니라면 그냥 부수지 않고 진행한다.
            if (mat[ny][nx] == 0) {
                // 이미 방문한 이력이 있으면 진행하지 않는다.
                if (visited[ny][nx][hasK]) {
                    continue
                }
                visited[ny][nx][hasK] = true

                queue.add(Pair(Pair(Pair(ny, nx), hasK), cnt + 1))
            } else {
                // 벽이라면 여태 부순 횟수와 최대로 부술 수 있는 k번 횟수를 확인한다.
                if (hasK < k) {

                    // 부수기 전에 (y, x) 위치에서 hasK + 1 번 부순 이력이 있으면 진행하지 않는다. 이미 진행했기 때문이다.
                    if (visited[ny][nx][hasK + 1]) {
                        continue
                    }
                    visited[ny][nx][hasK + 1] = true
                    queue.add(Pair(Pair(Pair(ny, nx), hasK + 1), cnt + 1))
                }
            }
        }
    }

    println(-1)
}

typealias Point = Pair<Pair<Pair<Int, Int>, Int>, Int>

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }