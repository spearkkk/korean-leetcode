fun main() {
    fun rotate(brd: Array<IntArray>, r: Int, c: Int, s: Int) {
        var count = 0 // 싸이클 수
        while (true) { // rotate를 한다. 제일 겉부터 안까지 진행한다.
            val leftTopY = r - s + count
            val leftTopX = c - s + count

            val rightBottomY = r + s - count
            val rightBottomX = c + s - count

            // rotate 할 수 있는지 체크
            if (leftTopX >= rightBottomX || leftTopY >= rightBottomY) {
                break
            }

            val yMin = leftTopY
            val yMax = rightBottomY
            val xMin = leftTopX
            val xMax = rightBottomX

            // right
            for (x in xMin + 1 .. xMax) {
                val tmp = brd[leftTopY][x]
                brd[leftTopY][x] = brd[leftTopY][leftTopX]
                brd[leftTopY][leftTopX] = tmp
            }

            // down
            for (y in yMin + 1 .. yMax) {
                val tmp = brd[y][xMax]
                brd[y][xMax] = brd[leftTopY][leftTopX]
                brd[leftTopY][leftTopX] = tmp
            }

            // left
            for (x in xMax - 1 downTo xMin) {
                val tmp = brd[yMax][x]
                brd[yMax][x] = brd[leftTopY][leftTopX]
                brd[leftTopY][leftTopX] = tmp
            }

            // up
            for (y in yMax - 1 downTo yMin) {
                val tmp = brd[y][xMin]
                brd[y][xMin] = brd[leftTopY][leftTopX]
                brd[leftTopY][leftTopX] = tmp
            }

            count += 1
        }
    }

    val (n, m, k) = readInts()

    val orgBrd = Array(n + 1) { IntArray(m + 1) { -1 } }

    for (y in 1 .. n) {
        val tmp = readInts()
        for (x in 1 .. m) {
            orgBrd[y][x] = tmp[x - 1]
        }
    }

    // rotate 할 지점 저장
    val rotates = ArrayList<Pair<Int, Pair<Int, Int>>>(k)

    for (idx in 0 until k) {
        val tmp = readInts()
        rotates.add(Pair(tmp[0], Pair(tmp[1], tmp[2])))
    }

    // rotate 지점들에 대한 모든 조합
    val visited = BooleanArray(k) { false }
    val arr = IntArray(k)

    var min = Int.MAX_VALUE

    fun bt(cnt: Int) {
        if (cnt == k) {

            val copied = Array(n + 1) { IntArray(m + 1) { -1 } }
            deepCopy(orgBrd, copied)

            for (idx in arr) {
                val tmp = rotates[idx]
                rotate(copied, tmp.first, tmp.second.first, tmp.second.second)
            }

            for (y in 1 .. n) {
                val tmp = copied[y].sum()

                if (tmp < min) {
                    min = tmp
                }
            }
            return
        }

        for (idx in 0 until k) {
            if (visited[idx]) {
                continue
            }

            arr[cnt] = idx
            visited[idx] = true
            bt(cnt + 1)

            visited[idx] = false
        }
    }

    bt(0)

    println(min + 1) // 인덱스 0 번쨰의 값을 -1로 초기화 했기 때문에 sum 할 때 -1도 계산해서 1을 다시 더한다.
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

fun deepCopy(source: Array<IntArray>, dest: Array<IntArray>) {
    for (y in source.indices) {
        for (x in 0 until source[y].size) {
            dest[y][x] = source[y][x]
        }
    }
}
