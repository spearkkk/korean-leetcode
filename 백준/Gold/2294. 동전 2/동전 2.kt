fun main() {
    val (n, k) = readInts()
    val coins = IntArray(n)
    val memo = IntArray(100000 + 1) { 100000 + 1 }

    repeat(n) {
        coins[it] = readInt()
        memo[coins[it]] = 1
    }

    for (i in 1 .. k) {
        for (coin in coins) {
            if (i - coin > 0) {
                val cnt = memo[i - coin] + 1
                if (cnt < memo[i]) {
                    memo[i] = cnt
                }
            }
        }
    }

    println(if (memo[k] == 100000 + 1) -1 else memo[k])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }