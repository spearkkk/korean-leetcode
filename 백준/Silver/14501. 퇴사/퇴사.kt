fun main() {
    val n = readInt()
    val t = IntArray(n + 1)
    val p = IntArray(n + 1)
    val d = IntArray(n + 2) { 0 } // 1-based index와 (n + 1)일에 대한 처리, d[k]는 k시점에서의 최댓값
    for (i in 0 until n) {
        val (tmpT, tmpP) = readInts()
        t[i + 1] = tmpT
        p[i + 1] = tmpP
    }

    if (t[n] == 1) {
        d[n] = p[n]
    }

    for (i in n - 1 downTo 1) { // 역순으로 조사해본다.
        if (i + t[i] <= n + 1) { // 현재 상담을 할 수 있다면 상담을 한다.
//            d[i] += p[i]
//
//            var max = 0 // 현재 상담을 한 후, 나머지 기간에서의 최댓값을 더한다.
//            for (j in i + t[i] .. n) {
//                if (max < d[j]) {
//                    max = d[j]
//                }
//            }
//            d[i] += max

            // d[i]가 최댓값을 항상 보장한다면
            d[i] = kotlin.math.max(p[i] + d[i + t[i]], d[i + 1])
        } else {
            d[i] = d[i + 1]
        }
    }
    println(d.max())
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }