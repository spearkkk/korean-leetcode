fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    /**
     * a <= b <= c <= d
     *
     * |(a + d) - (b + c)|
     * = (a + d) - (b + c) or (b + c) - (a + d)
     * = (d - c) - (b - a) or - {(d - c) - (b - a)}
     * = |(d - c) - (b - a)|
     *
     * ref.) https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x14/solutions/20366.cpp
     */
    val n = readInt()
    val numbers = readInts().sorted()


    var min = 1_000_000_000 + 1

    for (a in 0 until n) {
        for (d in a + 3 until n) {
            var b = a + 1
            var c = d - 1

            while (b < c) {
                val da = numbers[a] + numbers[d]
                val cb = numbers[c] + numbers[b]
                min = kotlin.math.min(min, kotlin.math.abs(da - cb))

                if (da < cb) {
                    c -= 1
                } else {
                    b += 1
                }
            }
        }
    }
    println(min)
}