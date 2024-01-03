import java.math.BigInteger

fun main() {
    val n = readInt()

    val mat = Array(n) { IntArray(n) }
    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
    }

    // dp[y][x]: (x, y)좌표계까지 올 수 있는 경로의 수
    val dp = Array(n) { Array(n) { BigInteger.ZERO } }
    dp[0][0] = BigInteger.ONE // (0, 0)부터 시작하기 때문에

    for (y in 0 until n) {
        for (x in 0 until n) {
            if (dp[y][x] == BigInteger.ZERO) {
                continue // dp[y][x] == 0 뜻은 (x, y)로 올 수 있는 경로가 없다는 뜻이다
            }

            if (y == n - 1 && x == n - 1) {
                break // 맨 오른쪽 아래인 도착 지점이다.
            }

            val ny = y + mat[y][x]
            if (ny < n) {
                dp[ny][x] = dp[ny][x] + dp[y][x] // 아래로 가는 경로
            }

            val nx = x + mat[y][x]
            if (nx < n) {
                dp[y][nx] = dp[y][nx] + dp[y][x] // 오른쪽으로 가는 경로
            }
        }
    }

    println(dp[n - 1][n - 1])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }