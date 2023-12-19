fun main() {
    repeat(readInt()) {
        val n = readInt()

        val arr = Array(2) { IntArray(n) }

        for (y in 0 .. 1) {
            arr[y] = readInts().toIntArray()
        }
        
        val s = Array(2) { IntArray(n) { 0 } }

        s[0][0] = arr[0][0]
        s[1][0] = arr[1][0]

        if (n >= 2) {
            s[0][1] = arr[0][1] + arr[1][0]
            s[1][1] = arr[1][1] + arr[0][0]

            for (k in 2 until n) {
                s[0][k] = kotlin.math.max(s[1][k - 1], s[1][k - 2]) + arr[0][k]
                s[1][k] = kotlin.math.max(s[0][k - 1], s[0][k - 2]) + arr[1][k]
            }
        }

        println(kotlin.math.max(s[0][n - 1], s[1][n - 1]))
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }