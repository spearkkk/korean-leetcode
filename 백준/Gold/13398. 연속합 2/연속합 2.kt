fun main() {

    fun max(left: Int, right: Int): Int {
        if (left < right) {
            return right
        }
        return left
    }

    val n = readInt()

    val numbers = readInts()

    val sum = Array(n) { IntArray(2) { numbers[0] } }

    sum[0][0] = numbers[0]
    sum[0][1] = numbers[0]

    var max = numbers[0]

    for (idx in 1 until n) {
        sum[idx][0] = max(sum[idx - 1][0] + numbers[idx], numbers[idx])
        sum[idx][1] = max(sum[idx - 1][0], sum[idx - 1][1] + numbers[idx])
        max = max(max, max(sum[idx][0], sum[idx][1]))
    }

    println(max)

}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }