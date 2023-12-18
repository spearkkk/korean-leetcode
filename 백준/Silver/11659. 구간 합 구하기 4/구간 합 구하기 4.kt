fun main() {
    val (n, m) = readInts()
    val numbers = readInts()
    val sum = IntArray(n)
    sum[0] = numbers[0]
    for (i in 1 until n) {
        sum[i] = sum[i - 1] + numbers[i]
    }

    val sb = StringBuilder()
    repeat(m) {
        val (left, right) = readInts()
        if (left == 1) {
            sb.append(sum[right - 1])
            sb.appendLine()
        } else {
            sb.append(sum[right - 1] - sum[left - 2])
            sb.appendLine()
        }
    }
    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }