fun main() {
    val n = readInt()

    val dp = Array(n) { IntArray(3) }
    dp[0][0] = 1
    dp[0][1] = 1
    dp[0][2] = 1

    for (k in 1 until n) {
        dp[k][0] = (dp[k - 1][0] + dp[k - 1][1] + dp[k - 1][2]) % 9901
        dp[k][1] = (dp[k - 1][0] + dp[k - 1][2]) % 9901
        dp[k][2] = (dp[k - 1][0] + dp[k - 1][1]) % 9901
    }

    var answer = dp[n - 1][0]
    answer += dp[n - 1][1]
    answer %= 9901
    answer += dp[n - 1][2]
    answer %= 9901

    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }