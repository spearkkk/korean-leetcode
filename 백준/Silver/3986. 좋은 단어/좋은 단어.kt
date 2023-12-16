fun main() {
    val n = readInt()

    var cnt = 0
    repeat(n) {
        val stack = ArrayList<Char>()

        for (c in readStr()) {
            if (stack.isEmpty()) {
                stack.add(c)
                continue
            }

            if (stack.last() == c) {
                stack.removeLast()
                continue
            }

            stack.add(c)
        }

        if (stack.isEmpty()) {
            cnt += 1
        }
    }
    println(cnt)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }