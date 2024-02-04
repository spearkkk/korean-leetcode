fun main() {
    /**
     * 최장 수열(LIS) 문제
     */

    val n = readInt()
    val numbers = IntArray(n)
    val dp = IntArray(n)

    for (i in 0 until n) {
        val curNumber = readInt()
        numbers[i] = curNumber
        dp[i] = 1

        for (j in 0 until i) {
            if (numbers[j] < numbers[i]) {
                dp[i] = kotlin.math.max(dp[i], dp[j] + 1)
            }
        }
    }

    println(n - dp.max())
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }