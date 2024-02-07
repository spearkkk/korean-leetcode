fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    /**
     * 스택
     * 0이 들어올 경우 가장 위에 있는 값을 제거해주면 된다.
     * 단, 0이 들어와도 가장 위에 있는 값이 없다면 제거할 필요는 없다.
     *
     */

    val stack = mutableListOf<Int>()
    repeat(readInt()) {
        stack.add(readInt())
        if (stack.last() == 0) {
            if (stack.isNotEmpty()) {
                stack.removeLast()
            }
            if (stack.isNotEmpty()) {
                stack.removeLast()
            }
        }
    }
    println(stack.sum())
}