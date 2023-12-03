fun main() {
    var ans = 0

    val line = readStr()
    var last = ')'
    val stack = arrayListOf<Char>()
    for (nxt in line) {
        if (nxt == '(') {
            stack.add(nxt)
        }
        if (nxt == ')') {
            stack.removeLast()

            if (last == '(') {
                // lazer
                ans += stack.size
            } else {
                ans += 1
            }
        }

        last = nxt
    }
    println(ans)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }