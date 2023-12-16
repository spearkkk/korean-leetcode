fun main() {
    val n = readInt()

    val array = ArrayList<Pair<Int, Pair<Char, Int>>>()

    repeat(n) {
        val (x, r) = readInts()

        var left = x - r
        var right = x + r
        if (left > right) {
            val tmp = left
            left = right
            right = left
        }

        array.add(Pair(left, Pair('l', it)))
        array.add(Pair(right, Pair('r', it)))
    }

    array.sortBy { it.first }

    val stack = ArrayList<Int>()
    for (i in array) {
        if ('l' == i.second.first) {
            stack.add(i.second.second)
            continue
        }

        if (stack.isEmpty()) {
            println("NO")
            return
        }

        if (stack.last() != i.second.second) {
            println("NO")
            return
        }
        stack.removeLast()
    }

    if (stack.isNotEmpty()) {
        println("NO")
        return
    }
    println("YES")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }