fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val (n, m) = readInts()
    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = readInt()
    }
    numbers.sort()

    var left = 0
    var right = 0

    var answer = Int.MAX_VALUE
    while (left < n) {
        while (right < n && numbers[right] - numbers[left] < m) {
            right += 1
        }
        if (right >= n) {
            break
        }

        val diff = numbers[right] - numbers[left]
        if (diff < answer) {
            answer = diff
        }
        left += 1
    }
    println(answer)
}