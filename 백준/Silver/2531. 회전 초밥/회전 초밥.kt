fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    /**
     * ref.) https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x14/solutions/2531.cpp
     */
    val (n, d, k, c) = readInts()
    val numbers = IntArray(n + n) // rotate 를 쉽게 처리하기 위해 2배 길이로 저장
    repeat(n) {
        numbers[it] = readInt()
        numbers[n + it] = numbers[it]
    }

    val ateCount = IntArray(d + 1)
    ateCount[c] += 1
    var uniqueCount = 1
    var answer = 1

    fun vomit(m: Int) {
        ateCount[m] -= 1
        if (ateCount[m] == 0) {
            uniqueCount -= 1
        }
    }

    fun eat(m: Int) {
        if (ateCount[m] == 0) {
            uniqueCount += 1
            answer = kotlin.math.max(answer, uniqueCount)
        }
        ateCount[m] += 1
    }

    for (i in 0 until n * 2) {
        if (i >= k) {
            vomit(numbers[i - k])
        }
        eat(numbers[i])
    }

    println(answer)
}