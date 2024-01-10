fun main() {
    val (n, m) = readInts()
    val mat = Array(n) { IntArray(m) }
    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
    }

    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)
    val d = Array(n) { IntArray(m) { -1 } } // -1로 유지되었다는건 지나가지 않았다는 것

    // dfs
    fun dfs(y: Int, x: Int): Int {
        if (y == n - 1 && x == m - 1) {
            return 1
        }

        if (d[y][x] != -1) {
            return d[y][x]
        }

        var tmp = 0

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue
            }

            if (mat[ny][nx] < mat[y][x]) {
                tmp += dfs(ny, nx)
                d[y][x] = tmp
            }
        }

        return tmp
    }

    println(dfs(0, 0))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }