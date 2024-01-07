fun main() {
    repeat(readInt()) {
        val (n, m) = readInts()

        var c = 1
        for (i in 0 until n) {
            c *= (m - i)
            c /= (i + 1)
        }
        println(c)
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }