fun main() {
    val answer = StringBuilder()
    var cnt = 0
    while (true) {
        val n = readInt()
        if (n == 0) {
            break
        }
        cnt += 1

        val d = Array(100_000 + 1) { IntArray(3) }

        for (y in 1 .. n) {
            d[y] = readInts().toIntArray()
        }

        d[1][0] = 1_000_000 // cannot reach to left side of first line
        if (d[1][2] < 0) {
            d[1][2] += d[1][1]
        } else {
            d[1][2] = 1_000_000
        }

        for (y in 2 .. n) {
            for (x in 0 until  3) {
                if (x == 0) {
                    d[y][0] += kotlin.math.min(d[y - 1][x], d[y - 1][1])
                } else if (x == 1) {
                    d[y][1] += kotlin.math.min(d[y - 1][0], kotlin.math.min(d[y - 1][x], kotlin.math.min(d[y - 1][x + 1], d[y][0])))
                } else {
                    d[y][2] += kotlin.math.min(d[y - 1][1], kotlin.math.min(d[y - 1][2], d[y][1]))
                }
//                println("y: $y, x: $x, d[y][x]: ${d[y][x]}")
            }
        }

        answer.append("${cnt}. ${d[n][1]}")
        answer.appendLine()
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }