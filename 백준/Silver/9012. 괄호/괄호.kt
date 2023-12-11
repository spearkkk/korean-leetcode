fun main() {
    val n = readInt()

    repeat(n) {
        val line = readStr()

        val stack = ArrayList<Char>()

        var flag = true
        for (c in line) {
            if (c == '(') {
                stack.add(c)
                continue
            }

            if (c == ')') {
                if (stack.isEmpty()) {
                    flag = false
                    break
                }
                stack.removeLast()
            }
        }
        if (stack.isNotEmpty() || !flag) {
            println("NO")
        } else if(flag) {
            println("YES")
        }
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }