fun main() {
    val n = readInt()

    val minus = mutableListOf<Long>()
    val plus = mutableListOf<Long>()
    var zeroExist = false

    repeat(n) {
        val tmp = readLong()

        if (tmp == 0L) {
            zeroExist = true

        } else if (tmp < 0) {
            minus.add(tmp)
        } else {
            plus.add(tmp)
        }
    }

    minus.sort()
    plus.sortDescending()

    var result = 0L

    for (i in 0 until minus.size / 2) {
        result += minus[2 * i] * minus[2 * i + 1]
        minus[2 * i] = 0
        minus[2 * i + 1] = 0
    }

    val leftMinus = minus.sum()
    if (leftMinus < 0 && !zeroExist) {
        result += leftMinus
    }

    for (i in 0 until plus.size / 2) {
        if (plus[2 * i] != 1L && plus[2 * i + 1] != 1L) {
            result += plus[2 * i] * plus[2 * i + 1]
            plus[2 * i] = 0
            plus[2 * i + 1] = 0
        }
    }

    result += plus.sum()
    println(result)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }