fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

typealias HeightToNumber = Pair<Int, Int>

fun main() {
    /**
     * dp[y][x]: y번째 인덱스부터 x번째 인덱스까지의 팰린드롬이면 1, 아니면 0
     *
     * Case 1) y == x 이면 1, y != x 이면 0
     * Case 2) dp[y + 1][x - 1] == 1 && mat[y] == mat[x] 이면 1, 아니면 0
     */

    val n = readInt()
    val mat = IntArray(n + 1)
    val tmp = readInts()
    for (y in 1 .. n) {
        mat[y] = tmp[y - 1]
    }

    val dp = Array(n + 1) { IntArray(n + 1) }

    // Case 1)
    for (y in 1 .. n) {
        dp[y][y] = 1
    }

    // dp[1][4]는 dp[2][3]을 바라보기 때문에 y 루프는 내림차순으로 돌아야한다.
    for (y in n downTo 1) {
        for (x in y + 1 .. n) {
            // Case 2)
            if (mat[y] != mat[x]) {
                continue
            }

            val ny = y + 1
            val nx = x - 1
            if (ny <= nx) {
                dp[y][x] = dp[ny][nx]
            } else {
                // edge case
                dp[y][x] = 1
            }
        }
    }

//    for (y in 1 .. n) {
//        for (x in 1 .. n) {
//            print(dp[y][x])
//        }
//        println()
//    }
    val answer = StringBuilder()
    repeat(readInt()) {
        val (s, e) = readInts()
        answer.append(dp[s][e])
        answer.appendLine()
    }
    println(answer)
}