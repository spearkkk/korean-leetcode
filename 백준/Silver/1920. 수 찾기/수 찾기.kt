fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val n = readInt()
    var numbers = readInts().toSet()

    val m = readInt()
    val targets = readInts()
    for (i in 0 until m) {
        println(if (numbers.contains(targets[i])) 1 else 0)
    }
}