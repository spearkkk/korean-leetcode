fun main() {
    val (n, k) = readInts()
    val rocks = readInts().toIntArray()

    val memo = BooleanArray(n) { false }

    fun cost(i: Int, j: Int): Int {
        return (j - i) * (1 + kotlin.math.abs(rocks[i] - rocks[j]))
    }

    for (dest in 1 until  n) {
        memo[dest] = cost(0, dest) <= k
        for (src in 1 until dest) {
            if (memo[dest]) {
                break
            }

            memo[dest] = (memo[src] && cost(src, dest) <= k)
        }
    }

    println(if (memo[n - 1]) "YES" else "NO")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }