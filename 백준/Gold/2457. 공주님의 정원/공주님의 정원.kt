fun main() {
    val n = readInt()

    val starts = IntArray(n)
    val ends = IntArray(n)
    val marks = BooleanArray(n)

    repeat(n) {
        val (startM, startD, endM, endD) = readInts()

        starts[it] = startM * 100 + startD
        ends[it] = endM * 100 + endD
    }


    val startPoint = 3 * 100 + 1
    val endPoint = 11 * 100 + 30

    var currentCoveredPoint = startPoint
    var cur = -1
    var cnt = 0

    while (currentCoveredPoint <= endPoint) {
        for (i in 0 until n) {
            if (!marks[i] && starts[i] <= currentCoveredPoint && currentCoveredPoint < ends[i]) {
                if (cur == -1 || ends[cur] < ends[i]) {
                    cur = i
                }
            }
        }


        if (cur == -1) {
            println(0)
            return
        }

//        println("cur: $cur, start: ${starts[cur]}, end: ${ends[cur]}")

        currentCoveredPoint = ends[cur]

        marks[cur] = true
        cnt += 1

        cur = -1
    }

    println(cnt)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }