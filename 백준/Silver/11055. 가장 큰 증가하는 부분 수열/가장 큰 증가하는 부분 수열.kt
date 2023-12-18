fun main() {
    val n = readInt()
    val a = readInts()

    val d = IntArray(n)
    d[0] = a[0]

    for (k in 1 until n) {
        var max = a[k]
        for (i in 0 until k) {
            if(a[k] > a[i]) {
                max = kotlin.math.max(max, d[i] + a[k])
            }
        }
        d[k] = max
    }
    println(d.max())
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }