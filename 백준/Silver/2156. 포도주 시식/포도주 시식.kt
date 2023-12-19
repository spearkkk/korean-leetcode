fun main() {
    val n = readInt()
    val a = IntArray(n)

    repeat(n) {
        a[it] = readInt()
    }

    if (n == 1) {
        println(a[0])
        return
    } else if (n == 2) {
        println(a[0] + a[1])
        return
    }

    val s = IntArray(n)
    s[0] = a[0]
    s[1] = a[0] + a[1]
    s[2] = kotlin.math.max(a[0] + a[1], kotlin.math.max(a[0] + a[2], a[1] + a[2]))

    for (i in 3 until n) {
        s[i] = kotlin.math.max(s[i - 1], kotlin.math.max(s[i - 2] + a[i], s[i - 3] + a[i - 1] + a[i]))
    }

    println(s[n - 1])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }