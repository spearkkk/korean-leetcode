fun main() {

    val primes = intArrayOf(2, 3, 5, 7)

    val n = readInt()

    fun isPrime(prime: Int): Boolean {
        for (idx in 2 .. kotlin.math.sqrt(prime.toDouble()).toInt()) {
            if (prime % idx == 0) {
                return false
            }
        }
        return true
    }

    fun bt(cnt: Int, prime: Int) {
        if (cnt == n) {
            println(prime)
            return
        }

        for (idx in 1 .. 9) {
            val nxt = prime * 10 + idx
            if (isPrime(nxt)) {
                bt(cnt + 1, nxt)
            }
        }
    }

    for (idx in primes.indices) {
        bt(1, primes[idx])
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }