fun main() {
    // https://youtu.be/SPVOKqMDerQ?si=2PUCh-mc-Hr4TwTp

    val n = readInt()

    val dp = Array(n) { IntArray(12) { 0 } }

    // idx 1 -> 0
    // idx 2 -> 1
    // idx 10 -> 9
    for (i in 2 .. 10) {
        dp[0][i] = 1
    }

    for (i in 1 until n) {
        for (j in 1 .. 10) {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000 // 양쪽 대각선 위의 같을 더 한다. 해당 숫자로 끝나기 때문이다. 1, 3 으로 12, 23 를 만드니까
        }
    }

    var answer = 0
    for (i in 1 .. 10) {
        answer = (answer + dp[n - 1][i]) % 1_000_000_000
    }
    println(answer % 1_000_000_000)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }