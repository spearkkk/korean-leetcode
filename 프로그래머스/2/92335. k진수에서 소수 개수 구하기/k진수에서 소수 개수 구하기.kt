class Solution {
    private fun isPrime(n: Long): Boolean {
        if (n <= 1) {
            return false
        }
        val k = kotlin.math.sqrt(n + 0.0).toInt()
        for (i in 2 .. k) {
            if (n % i == 0L) {
                return false
            }
        }
        return true
    }

    fun solution(n: Int, k: Int): Int {
        var anotherN = n

        var cnt = 0
        var current = 1

        while (current < n) {
            current *= k
            cnt += 1
        }

        val kBased = IntArray(cnt + 1)

        for (i in cnt downTo 0) {
            kBased[cnt - i] = anotherN / current
            anotherN %= current
            current /= k
        }

//        println(kBased.joinToString(""))
        val realN = kBased.joinToString("")
        return realN.split("0")
            .filter { it.isNotBlank() }
            .map { it.toLong() }
            .count { isPrime(it) }
    }
}