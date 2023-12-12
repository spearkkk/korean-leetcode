fun main() {
    val n = readInt()

    val arr = IntArray(n)
    repeat(n) {
        arr[it] = (readInt())
    }

    val stack = java.util.Stack<Int>()

    var cursor = 0

    val sb = StringBuilder()
    for (nth in 1 .. n) {
        while (stack.isNotEmpty() && stack.peek() == arr[cursor]) {
            stack.pop()
            sb.appendLine("-")
            cursor += 1
        }

        stack.push(nth)
        sb.appendLine("+")
    }

    while (stack.isNotEmpty() && stack.peek() == arr[cursor] && cursor < n) {
        stack.pop()
        sb.appendLine("-")
        cursor += 1
    }

    if (cursor != n || stack.isNotEmpty()) {
        println("NO")
    } else {
        println(sb)
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()