fun main() {
    val n = readInt()
    val arr = readInts().toTypedArray()

    val ops = readInts().toTypedArray()

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    fun bt(cur: Int) {
        if (cur == n - 1) {
            if (arr[n - 1] > max) {
                max = arr[n - 1]
            }
            if (arr[n - 1] < min) {
                min = arr[n - 1]
            }
            return
        }

        for (idx in 0 .. 3) {
            if (ops[idx] <= 0) {
                continue
            }

            ops[idx] -= 1

            val nxt = when (idx) {
                0 -> {
                    arr[cur] + arr[cur + 1]
                }
                1 -> {
                    arr[cur] - arr[cur + 1]
                }
                2 -> {
                    arr[cur] * arr[cur + 1]
                }
                else -> {
                    arr[cur] / arr[cur + 1]
                }
            }

            val tmp = arr[cur + 1]
            arr[cur + 1] = nxt
            bt(cur + 1)

            arr[cur + 1] = tmp
            ops[idx] += 1
        }
    }

    bt(0)

    println(max)
    println(min)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }