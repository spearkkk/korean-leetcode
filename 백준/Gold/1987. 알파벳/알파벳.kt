fun main() {
    val (r, c) = readInts()

    val board = Array<String>(r) { "" }

    for (y in 0 until r) {
        board[y] = readStr()
    }

    val visited = Array(r) { BooleanArray(c) { false } }
    val anotherVisited = mutableSetOf<Char>()

    val directionY = intArrayOf(0, 1, 0, -1)
    val directionX = intArrayOf(1, 0, -1, 0)

    fun bt(y: Int, x: Int): Int {
        var tmpMax = 0
        for (idx in 0 until 4) {
            val ny = y + directionY[idx]
            val nx = x + directionX[idx]

            if (ny < 0 || ny >= r) {
                continue
            }

            if (nx <0 || nx >= c) {
                continue
            }

            if (visited[ny][nx]) {
                continue
            }

            if (anotherVisited.contains(board[ny][nx])) {
                continue
            }

            visited[ny][nx] = true
            anotherVisited.add(board[ny][nx])
            val tmp = bt(ny, nx) + 1
            if (tmpMax < tmp) {
                tmpMax = tmp
            }

            visited[ny][nx] = false
            anotherVisited.remove(board[ny][nx])
        }
        return tmpMax
    }

    visited[0][0] = true
    anotherVisited.add(board[0][0])
    println(bt(0, 0) + 1)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }


fun max(left: Int, right: Int): Int {
    if (left < right) {
        return right
    }
    return left
}