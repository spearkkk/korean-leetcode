fun main() {
    val n = readInt()
    val numbers = IntArray(n)

    for (i in 0 until n) {
        numbers[i] = readInt()
    }

    var currentMax = numbers[n - 1]
    var answer = 0

    for (i in n - 2 downTo 0) {
        if (currentMax <= numbers[i]) {
            currentMax -= 1
            answer += numbers[i] - currentMax
        } else {
            currentMax = numbers[i]
        }
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }