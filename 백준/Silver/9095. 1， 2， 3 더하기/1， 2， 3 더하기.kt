fun main() {
    val t = readInt()
    repeat(t) {
        val n = readInt()

        val d = IntArray(11 + 1) { 0 }
        d[1] = 1
        d[2] = 2
        d[3] = 4

        for (i in 4 .. n) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3]
        }

        println(d[n])
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }