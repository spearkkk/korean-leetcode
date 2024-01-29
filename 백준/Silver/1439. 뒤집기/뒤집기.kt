fun main() {
    val str = readStr()
    var cntZero = 0
    var cntFirst = 0

    var last = 'c' // meaningless character for initial status

    for (i in str.indices) {
        if (last == str[i]) {
            continue
        }
        last = str[i]
        if (str[i] == '0') {
            cntZero += 1
        } else {
            cntFirst += 1
        }
    }

    println(if (cntZero == 0 || cntFirst == 0) 0 else kotlin.math.min(cntFirst, cntZero))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }