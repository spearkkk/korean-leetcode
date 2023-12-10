fun main() {
    val n = readInt()

    val arr = ArrayList<Pair<Long, Long>>()

    for (idx in 0 until n) {
        val (s, b) = readLongs()
        arr.add(Pair(s, b))
    }

    var min = Long.MAX_VALUE

    fun bt(cursor: Int, s: Long, b: Long) {
        if (cursor == n) {
            if (s == 1L || b == 0L) {
                return
            }
            if (kotlin.math.abs(s - b) < min) {
                min = kotlin.math.abs(s - b)
            }
            return
        }

        bt(cursor + 1, s, b)
        bt(cursor + 1, s * arr[cursor].first, b + arr[cursor].second)
    }

    bt(0, 1, 0)

    println(min)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }