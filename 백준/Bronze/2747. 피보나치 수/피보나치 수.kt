fun main() {
    val n = readInt()

    if (n <= 1) {
        println(n)
        return
    }
    
    val dp = IntArray(n + 1)
    dp[1] = 1
    for (i in 2 .. n) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    println(dp[n])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }