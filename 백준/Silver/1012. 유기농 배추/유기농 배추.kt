fun main() {
    val answer = StringBuilder()

    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    repeat(readInt()) {
        val (n, m, k) = readInts()
        val mat = Array(n) { IntArray(m) }

        repeat(k) {
            val (y, x) = readInts()

            mat[y][x] = 1
        }

        val visited = Array(n) { BooleanArray(m) }

        fun dfs(y: Int, x: Int) {
            if (visited[y][x]) {
                return
            }

            visited[y][x] = true

            for (i in 0 .. 3) {
                val ny = y + dirY[i]
                val nx = x + dirX[i]

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue
                }

                if (mat[ny][nx] == 0) {
                    continue
                }

                dfs(ny, nx)
            }
        }

        var cnt = 0
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (visited[y][x]) {
                    continue
                }
                if (mat[y][x] == 1) {
                    cnt += 1
                    dfs(y, x)
                }
            }
        }

        answer.append(cnt)
        answer.appendLine()
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }