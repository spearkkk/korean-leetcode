fun main() {
    val t = readInt()

    val answer = StringBuilder()

    // d[k]는 k를 1, 2, 3 숫자로 나타내는 방법의 수
    // 사용할 수 있는 숫자는 1, 2, 3이다.
    // 3보다 큰 숫자는 결국엔 1, 2, 3의 수를 사용해야하기 때문에
    // d[k] = d[k - 1] + d[k - 2] + d[k - 3] 으로 나타낼 수 있다.
    val d = IntArray(1_000_000 + 1)
    d[1] = 1
    d[2] = 2
    d[3] = 4

    repeat(t) {
        val n = readInt()

        for (k in 4 .. n) {
            if (d[k] != 0) {
                continue
            }

            for (m in 1 .. 3) {
                d[k] += d[k - m]
                d[k] %= 1_000_000_009
            }
        }

        answer.append(d[n])
        answer.appendLine()
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }