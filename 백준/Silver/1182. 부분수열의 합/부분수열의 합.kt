fun main() {
    val (n, s) = readInts()

    val holder = readInts()

    var cnt = 0

    fun bt(cursor: Int, currentSum: Int) {
        if (cursor >= holder.size) {
            if (currentSum == s) {
                cnt += 1
            }
            return
        }

        bt(cursor + 1, currentSum + holder[cursor])
        bt(cursor + 1, currentSum)
    }


    bt(0, 0)
    if (s == 0) { // 하나도 선택하지 않았을 떄를 고려한다.
        cnt -= 1
    }
    println(cnt)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }