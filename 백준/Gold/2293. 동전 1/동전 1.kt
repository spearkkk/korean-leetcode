fun main() {
    val (n, k) = readInts()
    val coins = IntArray(n)
    val memo = IntArray(100000 + 1) { 0 }

    repeat(n) {
        coins[it] = readInt()
    }

    memo[0] = 1

    for (coin in coins) {
        for (i in coin .. k) {
            memo[i] += memo[i - coin]
        }
    }

    println(memo[k])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }