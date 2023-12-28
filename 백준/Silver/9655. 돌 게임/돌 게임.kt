fun main() {
    val n = readInt()

    val d = BooleanArray(1000 + 1) { false }
    d[1] = true
    d[2] = false
    d[3] = true

    for (i in 4 .. n) {
        d[i] = !d[i - 1] || !d[i - 3]
    }

    println(if (d[n]) "SK" else "CY")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }