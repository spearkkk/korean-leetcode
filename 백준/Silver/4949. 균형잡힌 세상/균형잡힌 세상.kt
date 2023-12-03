fun main() {
    while (true) {
        val line = readStr()
        if (line == ".") {
            return
        }

        val stack = arrayListOf<Char>()

        var flag = true
        var idx = 0

        while (idx < line.length && flag) {
            val nxt = line[idx]
            if (nxt == '(' || nxt == '[') {
                stack.add(nxt)
            }

            if (nxt == ')') {
                if (stack.isEmpty() || stack.last() != '(') {
                    flag = false
                    break
                }
                stack.removeLast()
            }

            if (nxt == ']') {
                if (stack.isEmpty() || stack.last() != '[') {
                    flag = false
                    break
                }
                stack.removeLast()
            }
            idx += 1
        }

        if (!flag || stack.isNotEmpty()) {
            println("no")
        } else {
            println("yes")
        }
    }
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }