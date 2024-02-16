fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

typealias HeightToNumber = Pair<Int, Int>

fun main() {
    /**
     * ref.) https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x05/solutions/3015.cpp
     */
    val stack = mutableListOf<HeightToNumber>()
    val n = readInt()

    var answer = 0L

    repeat(n) {
        val height = readInt()

        var cnt = 1

        while (stack.isNotEmpty() && stack.last().first <= height) {
            answer += stack.last().second

            if (stack.last().first == height) {
                cnt += stack.last().second
            }
            stack.removeLast()
        }

        if (stack.isNotEmpty()) {
            answer += 1
        }
        stack.add(HeightToNumber(height, cnt))

    }
    println(answer)
}