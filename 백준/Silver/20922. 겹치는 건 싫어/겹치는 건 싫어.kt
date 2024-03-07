fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val (n, k) = readInts()
    val numbers = readInts()

    val touched = IntArray(100_000 + 1) // 1 <= a <= 100_000

    var left = 0
    var right = 0

    touched[numbers[right]] += 1

    var max = 1

    while (left < n) {
        while (right < n - 1 && touched[numbers[right + 1]] < k) {
            right += 1
            touched[numbers[right]] += 1
        }

        max = kotlin.math.max(max, right - left + 1)

        if (right >= n) {
            break
        }

        touched[numbers[left]] -= 1
        left += 1
    }

    println(max)
}