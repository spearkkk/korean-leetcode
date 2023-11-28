fun main() {
    val (n, m) = readInts()

    val matrix = Array(n) { Array(m) { 0 } }

    for (dn in 0 until n) {
        matrix[dn] = readStr().map { it.digitToInt() }.toTypedArray()
    }

    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, -1, 0, 1)

    val distant = Array(n) { Array(m) { -1 } }

    distant[0][0] = 1

    val queue = arrayListOf<Pair<Int, Int>>()
    queue.add(Pair(0, 0))

    while (queue.isNotEmpty()) {
        val cursor = queue.removeFirst()

        for (index in 0 until 4) {

            val nextCursor = Pair(cursor.first + dx[index], cursor.second + dy[index])

            if (nextCursor.first in 0 until n && nextCursor.second in 0 until m) {
                if (distant[nextCursor.first][nextCursor.second] == -1 && matrix[nextCursor.first][nextCursor.second] == 1) {
                    distant[nextCursor.first][nextCursor.second] = distant[cursor.first][cursor.second] + 1
                    queue.add(nextCursor)
                }
            }
        }
    }

    println(distant[n - 1][m - 1])
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }