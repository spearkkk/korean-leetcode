fun main() {
    val (n, m) = readInts()

    val board = Array(n + 1) { IntArray(n + 1) { 0 } }
    val s = Array(n + 1) { IntArray(n + 1) { 0 } }

    for (y in 1 .. n) {
        val arr = readInts()
        for (i in 0 until n) {
            board[y][i + 1] = arr[i]
            val x = i + 1
            s[y][x] = s[y][x - 1] + s[y - 1][x] - s[y - 1][x - 1] + board[y][x]
        }
    }

    repeat(m) {
        val points = readInts()
        val y1 = points[0]
        val x1 = points[1]
        val y2 = points[2]
        val x2 = points[3]

        println(s[y2][x2] - s[y2][x1 - 1] - s[y1 - 1][x2] + s[y1 - 1][x1 - 1])
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }