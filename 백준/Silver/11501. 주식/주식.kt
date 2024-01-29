fun main() {
    val sb = StringBuilder()
    repeat(readInt()) {
        val n = readInt()
        val numbers = readLongs()

        val maxNumbers = LongArray(n)

        maxNumbers[n - 1] = numbers[n - 1]
        var currentMax = numbers[n - 1]
        for (i in n - 2 downTo 0) {
            if (currentMax < numbers[i]) {
                currentMax = numbers[i]
            }
            maxNumbers[i] = currentMax
        }

        var answer = 0L
        for (i in 0 until n) {
            answer += maxNumbers[i] - numbers[i]
        }
        sb.append(answer)
        sb.appendLine()
    }
    print(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }