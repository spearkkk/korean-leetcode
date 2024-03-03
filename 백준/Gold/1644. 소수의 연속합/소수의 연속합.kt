fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    fun isPrime(n: Int): Boolean {
        val k = kotlin.math.sqrt(n + 0.0).toInt()
        for (i in 2 .. k) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }

    val n = readInt()
    val primes = arrayListOf<Int>()
    for (i in 2 .. n) {
        if (isPrime(i)) {
            primes.add(i)
        }
    }

    if (primes.size == 0) {
        println(0)
        return
    }

    var left = 0
    var right = 0

    var sum = primes[left]
    var answer = 0

    while (left < primes.size) {
        while (right < primes.size && sum < n) {
            right += 1
            if (right == primes.size) {
                break
            }
            sum += primes[right]
        }

        if (sum == n) {
            answer += 1
        }

        sum -= primes[left]
        left += 1
    }
    println(answer)
}