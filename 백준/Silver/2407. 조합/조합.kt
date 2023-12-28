import java.math.BigInteger

fun main() {
    val mat = Array(100 + 1) { Array(100 + 1) { BigInteger.ZERO } }

    val (n, m) = readInts()

    for (i in 1 .. n) {
        for (j in 0 .. i) {
            if (j == 0 || i == j) {
                mat[i][j] = BigInteger.ONE
            } else {
                mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j]
            }
        }
    }

    println(mat[n][m])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }