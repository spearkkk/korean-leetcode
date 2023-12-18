fun main() {
    val n = readInt()

    val max = n / 5

    for (k in max downTo 0) {
        val tmp = n - k * 5
        if (tmp % 3 == 0) {
            println(k + tmp / 3)
            return
        }
    }
    println(-1)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }