fun main() {
    
    fun max(left: Int, right: Int): Int {
        if (left < right) {
            return right
        }
        return left
    }

    val n = readInt()

    val numbers = readInts()

    val sum = IntArray(n) { -1001 }

    sum[0] = numbers[0]

    var max = numbers[0]

    for (idx in 1 until n) {
        sum[idx] = max(sum[idx - 1] + numbers[idx], numbers[idx])
        max = max(max, sum[idx])
    }

    println(max)

}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }