fun main() {
    // 1: SK
    // 2: CY
    // 3: SK
    // 4: SK
    // 5: 5 - 1, 5 - 3, 5 - 4

    val n = readInt()
    val d = BooleanArray(1000 + 1)
    d[1] = true
    d[2] = false
    d[3] = true
    d[4] = true

    for (k in 5 .. n) {
        d[k] = !d[k - 1] || !d[k - 3] || !d[k - 4]
    }

    println(if (d[n]) "SK" else "CY")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }