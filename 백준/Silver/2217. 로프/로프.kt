fun main() {
    val n = readInt()

    val ropes = IntArray(n)

    for (i in 0 until n) {
        ropes[i] = readInt()
    }

    ropes.sortDescending()

    var answer = 0

    for (i in 0 until n) {
        val tmp = (i + 1) * ropes[i]
        if (answer < tmp) {
            answer = tmp
        }
    }

    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }