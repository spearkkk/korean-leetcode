fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val n = readInt()
    val numbers = mutableMapOf<Int, Int>()
    for (it in readInts()) {
        numbers[it] = numbers.getOrDefault(it, 0) + 1
    }

    val answer = StringBuilder()
    readInt()
    val st = java.util.StringTokenizer(readln())
    while (st.hasMoreTokens()) {
        answer.append(numbers.getOrDefault(st.nextToken().toInt(), 0)).append(" ")
    }
    println(answer)
}