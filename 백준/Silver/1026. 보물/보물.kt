fun main() {
    val n = readInt()

    val a = readInts().sorted()
    val b = readInts().sortedDescending()

    var answer = 0
    for (i in 0 until n) {
        answer += a[i] * b[i]
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }