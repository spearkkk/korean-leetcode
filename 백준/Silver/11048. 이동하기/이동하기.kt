fun main() {
    val (n, m) = readInts()

    val mat = Array(n + 1) { IntArray(m + 1) }
    for (y in 1 .. n) {
        val tmp = readInts()
        for (x in 1 .. m) {
            mat[y][x] = tmp[x - 1]
        }
    }

    val dp = Array(n + 1) { IntArray(m + 1) }
    for (y in 1 .. n) {
        for (x in 1 .. m) {
            dp[y][x] = mat[y][x] + kotlin.math.max(kotlin.math.max(dp[y - 1][x], dp[y][x - 1]), dp[y - 1][x - 1])
        }
    }

//    for (y in 0 .. n) {
//        println(dp[y].joinToString(" "))
//    }
    println(dp[n][m])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }