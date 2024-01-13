fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val (n, m, k) = readInts()
    val mat = Array(n) { BooleanArray(m) }
    repeat(k) {
        val (x1, y1, x2, y2) = readInts()

        for (y in y1 until y2) {
            for (x in x1 until x2) {
                mat[y][x] = true
            }
        }
    }

    fun dfs(y: Int, x: Int): Int {
        mat[y][x] = true
        var cnt = 1

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue
            }
            if (!mat[ny][nx]) {
                cnt += dfs(ny, nx)
            }
        }
        return cnt
    }

    var cnt = 0
    val areas = arrayListOf<Int>()
    for (y in 0 until n) {
        for (x in 0 until m) {
            if (mat[y][x]) {
                continue
            }
            cnt += 1
            areas.add(dfs(y, x))
        }
    }
    println(cnt)
    println(areas.sorted().joinToString(" "))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }