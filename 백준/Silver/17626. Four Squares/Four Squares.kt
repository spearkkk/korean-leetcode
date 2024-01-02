fun main() {
    val n = readInt()

    // memo[k]: k를 나타낼 수 있는 제곱 수들에 대한 최소 개수
    val memo = IntArray( n + 1) { 50_000 }
    memo[0] = 0 // 제곱 수에 사용함, 4, 9, 16, 25
    memo[1] = 1

    for (k in 2 .. n) {
        val tmp = kotlin.math.sqrt(k.toFloat()).toInt()
        for (j in tmp downTo tmp / 2) {
            val cnt = memo[k - j * j] + 1
            if (cnt < memo[k]) {
                memo[k] = cnt
            }
        }
    }

    println(memo[n])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }