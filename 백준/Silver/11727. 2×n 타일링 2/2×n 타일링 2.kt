fun main() {
    val n = readInt()

    val s = Array(10001) { IntArray(2) }
    s[1][0] = 1
    s[1][1] = 0
    s[2][0] = 1
    s[2][1] = 2

    for (k in 3 .. n) {
        s[k][0] = (s[k - 1][0] + s[k - 1][1]) % 10007
        s[k][1] = 2 * (s[k - 2][0] + s[k - 2][1]) % 10007
    }
    println((s[n][0] + s[n][1]) % 10007)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }