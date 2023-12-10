fun main() {
    val colors = IntArray(6) { 5 } // size와 index 값을 맞추기 위해 6으로 한다.

    val originBrd = Array(10) { IntArray(10) { 0 } }

    for (y in 0 until 10) {
        originBrd[y] = readInts().toIntArray()
    }

    val brd = deepCopy(originBrd)

    fun isDone(): Boolean {
        for (y in 0 until 10) {
            for (x in 0 until 10) {
                if (brd[y][x] == 1) {
                    return false
                }
            }
        }
        return true
    }

    fun marking(y: Int, x: Int, len: Int) {
        for (aY in y until y + len) {
            for (aX in x until x + len) {
                brd[aY][aX] = 0
            }
        }
    }

    fun unMarking(y: Int, x: Int, len: Int) {
        for (aY in y until y + len) {
            for (aX in x until x + len) {
                brd[aY][aX] = 1
            }
        }
    }

    fun check(y: Int, x: Int, len: Int): Boolean {
        for (aY in y until y + len) {
            for (aX in x until x + len) {
                if (brd[aY][aX] == 0) {
                    return false
                }
            }
        }

        return true
    }

    var min = Int.MAX_VALUE
    fun bt(cnt: Int) {
        if (min < cnt) { // 이미 사용한 개수가 이전 최솟값보다 많다면 더 보지 않는다.
            return
        }

        if (isDone()) { // 색종이 다 붙였는지 확인
            if (cnt < min) {
                min = cnt
            }
            return
        }

        for (y in 0 until 10) {
            for (x in 0 until 10) {
                if (brd[y][x] == 1) { // 색종이를 붙여야 함
                    for (len in 5 downTo 1) {
                        if (colors[len] <= 0) { // 색종이 고갈
                            continue
                        }

                        if (y + len > 10 || x + len > 10) {
                            continue
                        }

                        if (!check(y, x, len)) {
                            continue
                        }

                        colors[len] -= 1
                        marking(y, x, len)
                        bt(cnt + 1)

                        unMarking(y, x, len)
                        colors[len] += 1
                    }
                    return
                }
            }
        }
    }

    bt(0)
    println(if (min == Int.MAX_VALUE) -1 else min)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }

fun zeroFill(cnt: Int, number: Int) = println("%0${cnt}d".format(number))

fun max(left: Int, right: Int): Int {
    if (left < right) {
        return right
    }
    return left
}

fun deepCopy(source: Array<IntArray>): Array<IntArray> {
    val dest = Array(source.size) { IntArray(source[0].size) { 0 } }
    for (y in source.indices) {
        for (x in 0 until source[y].size) {
            dest[y][x] = source[y][x]
        }
    }
    return dest
}