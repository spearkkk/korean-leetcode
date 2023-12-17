fun main() {
    val n = readInt()
    val arr = IntArray(n)
    repeat(n) {
        arr[it] = readInt()
    }

    if (n == 1) {
        println(arr[0])
        return
    }

    val sum = Array(n) { IntArray(2) }
    // 0 -> 지금 계단을 밟고 이전 계단을 밟지 않은 상태, 그러니깐 점프해서 더 한 값
    // 1 -> 지금 계단을 밟고 이전 계단도 밟은 상태, 3개 연속으로 밟으면 안되니깐 이전 계단은 반드시 점프한 결과 값이어야 함
    // sum[k][0] = arr[k] + max(sum[k - 2][0], sum[k - 2][1])
    // sum[k][1] = arr[k] + sum[k - 1][0]

    sum[0][0] = arr[0]
    sum[0][1] = 0
    sum[1][0] = arr[1] + 0 // 점프해서 밟은 경우
    sum[1][1] = arr[1] + arr[0] // 두 계단 연속으로 밟은 경우

    for (i in 2 until n) {
        sum[i][0] = arr[i] + kotlin.math.max(sum[i - 2][0], sum[i - 2][1])
        sum[i][1] = arr[i] + sum[i - 1][0]
    }

    println("${kotlin.math.max(sum[n - 1][0], sum[n - 1][1])}")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }