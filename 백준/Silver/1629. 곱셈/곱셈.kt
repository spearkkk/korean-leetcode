fun main() {
    val (a, b, c) = readln().split(" ").map { it.toLong() }

    fun mod(a: Long, b: Long, c: Long): Long {
        // 재귀함수 마지막 지점
        if (b == 1L) {
            return a % c
        }

        val tmp = mod(a, b / 2, c) % c
        if (b % 2 == 0L) {
            return tmp * tmp % c
        } else {
            return ((tmp * tmp % c) * a) % c
        }
    }
    println(mod(a, b, c))
}