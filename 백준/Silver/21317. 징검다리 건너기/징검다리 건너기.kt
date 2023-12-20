fun main() {
    val n = readInt()

    val arr = Array(21) { IntArray(2) { 0 } }
    for (x in 1 until n) {
        val (first, second) = readInts().toIntArray()
        arr[x][0] = first
        arr[x][1] = second
    }
    val k = readInt()

    // s[i][0]: i번째까지 매우 큰 점프를 사용하지 않은 경우
    // s[i][1]: i번째까지 한번이라도 매우 큰 점프를 사용한 경우
    val s = Array(21) { IntArray(2) { 0 } }

    for (i in 0 .. n) {
        s[i][0] = 999999
        s[i][1] = 999999
    }

    s[1][0] = 0
    s[2][0] = arr[1][0]
    s[3][0] = kotlin.math.min(arr[1][0] + arr[2][0], arr[1][1])

    for (i in 4 .. n) {
        s[i][0] = kotlin.math.min(s[i - 1][0] + arr[i - 1][0], s[i - 2][0] + arr[i - 2][1])
        s[i][1] = kotlin.math.min(s[i - 3][0] + k, kotlin.math.min(s[i - 1][1] + arr[i - 1][0], s[i - 2][1] + arr[i - 2][1]))
    }
    println(kotlin.math.min(s[n][0], s[n][1]))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }