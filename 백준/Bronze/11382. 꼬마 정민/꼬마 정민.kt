fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }
    println("${a + b + c}")
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }
