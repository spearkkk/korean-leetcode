fun main() {

    val n = readInt()
    val board = Array(n) { IntArray(n) }

    for (y in 0 until n) {
        board[y] = readInts().toIntArray()
    }

    val pQueue = java.util.PriorityQueue<Int>(compareBy<Int?> { it }.reversed())

    var cnt = n
    for (y in n - 1 downTo 0) {
        pQueue.addAll(board[y].toTypedArray())
    }
    while (pQueue.isNotEmpty() && cnt > 1) {
        cnt -= 1
        pQueue.remove()
    }
    println(pQueue.poll())
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }