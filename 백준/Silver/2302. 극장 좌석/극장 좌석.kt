fun main() {
    val d = IntArray(40 + 1)
    d[0] = 1
    d[1] = 1

    // d[k] = d[k - 1] + d[k - 2], k개의 칸에서 배치할 수 있는 경우의 수
    for (i in 2 .. 40) {
        d[i] = d[i - 1] + d[i - 2]
    }

    val n = readInt()
    val m = readInt()

    var start = 1
    var end = n + 1 // 마지막 n번째 칸도 숫자를 넣어야하기 때문에 +1
    var answer = 1

    repeat(m) {
        end = readInt()

        answer *= d[end - start]
        start = end + 1
        end = n + 1
    }

    answer *= d[end - start]
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }