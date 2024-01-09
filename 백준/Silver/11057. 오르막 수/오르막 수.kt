fun main() {
    // d[k][l]: 길이가 k인 오르막 수 중에서 일의 자리가 l인 개수
    // d[3][1]: 길이가 3인 오르막 수 중에서 일의 자리가 1인 개수
    // d[k][l] = d[k - 1][l] + d[k - 1][l - 1] + d[k - 1][l - 2] + ... + d[k - 1][0]
    val d = Array(1000 + 1) { IntArray(10) }
    for (l in 0 .. 9) {
        d[1][l] = 1
    }

    val n = readInt()
    for (k in 2 .. n) {
        for (l in 0 .. 9) {
            for (m in l downTo 0) {
                d[k][l] += d[k - 1][m]
                d[k][l] %= 10_007
            }
        }
    }

    var answer = 0
    for (l in 0 .. 9) {
        answer += d[n][l]
        answer %= 10_007
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }