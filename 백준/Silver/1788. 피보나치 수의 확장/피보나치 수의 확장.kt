fun main() {
    // f[0] = 0
    // f[1] = 1
    // f[k] = f[k - 1] + f[k - 2], k > 1
    // f[k - 2] = f[k] - f[k - 1]

    val f = IntArray(1_000_000 + 1)
    f[0] = 0
    f[1] = 1

    val d = IntArray(1_000_000 + 1)
    d[0] = 0
    d[1] = 1

    val n = readInt()
    val absN = kotlin.math.abs(n)
    for (k in 2 .. absN) {
        f[k] = (f[k - 1] + f[k - 2]) % 1_000_000_000
        d[k] = (d[k - 2] - d[k - 1]) % 1_000_000_000
    }

    val tmp = if (n >= 0) f[n] else d[absN]
    if (tmp == 0) {
        println(0)
    } else if (tmp > 0){
        println(1)
    } else {
        println(-1)
    }
    println(kotlin.math.abs(tmp))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }