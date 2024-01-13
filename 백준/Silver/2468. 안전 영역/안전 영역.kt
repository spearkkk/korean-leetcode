fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val n = readInt()
    val heights = mutableSetOf(0) // 비가 하나도 오지 않을 경우, 0

    val mat = Array(n) { IntArray(n) }

    for (y in 0 until n) {
        val tmp = readInts()
        mat[y] = tmp.toIntArray()
        heights.addAll(tmp)
    }

    fun dfs(y: Int, x: Int, h: Int, visited: Array<BooleanArray>) {
        visited[y][x] = true

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                continue
            }
            if (mat[ny][nx] > h && !visited[ny][nx]) {
                dfs(ny, nx, h, visited)
            }
        }
    }

    var answer = 0
    var cnt = 0
    for (h in heights) {
        val visited = Array(n) { BooleanArray(n) }

        for (y in 0 until n) {
            for (x in 0 until n) {
                if (mat[y][x] > h && !visited[y][x]) {
                    dfs(y, x, h, visited)
                    cnt += 1
                }
            }
        }

//        println(visited.contentDeepToString())
//        println("h: $h, cnt: $cnt")

        if (answer < cnt) {
            answer = cnt
        }
        cnt = 0
    }

    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }