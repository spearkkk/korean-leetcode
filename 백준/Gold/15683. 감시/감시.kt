fun main() {
    val (n, m) = readInts()

    val board = Array(n) { IntArray(m) { 0 } }

    val cctvs = mutableListOf<Pair<Int, Int>>()

    for (y in 0 until n) {
        board[y] = readInts().toIntArray()
        for (x in 0 until m) {
            if (board[y][x] in 1..5) {
                cctvs.add(Pair(y, x))
            }
        }
    }

    fun goUp(position: Pair<Int, Int>, board: Array<IntArray>) {
        val x = position.second
        for (y in position.first downTo 0) {
            if (board[y][x] == 6) {
                break
            }
            if (board[y][x] == 0) {
                board[y][x] = -1
            }
        }
    }

    fun goDown(position: Pair<Int, Int>, board: Array<IntArray>) {
        val x = position.second
        for (y in position.first until n) {
            if (board[y][x] == 6) {
                break
            }
            if (board[y][x] == 0) {
                board[y][x] = -1
            }
        }
    }

    fun goLeft(position: Pair<Int, Int>, board: Array<IntArray>) {
        val y = position.first
        for (x in position.second downTo 0) {
            if (board[y][x] == 6) {
                break
            }
            if (board[y][x] == 0) {
                board[y][x] = -1
            }
        }
    }

    fun goRight(position: Pair<Int, Int>, board: Array<IntArray>) {
        val y = position.first
        for (x in position.second until m) {
            if (board[y][x] == 6) {
                break
            }
            if (board[y][x] == 0) {
                board[y][x] = -1
            }
        }
    }

    var min = Int.MAX_VALUE
    val direction = IntArray(cctvs.size) { 0 }

    fun count(): Int {
        val copied = Array(n) { IntArray(m) { 0 } }
        deepCopy(board, copied)

        for (idx in cctvs.indices) {
            val cctv = cctvs[idx]
            val y = cctv.first
            val x = cctv.second
            val dir = direction[idx]

            if (board[y][x] == 1) {
                when (dir) {
                    0 -> {
                        goRight(cctv, copied)
                    }
                    1 -> {
                        goDown(cctv, copied)
                    }
                    2 -> {
                        goLeft(cctv, copied)
                    }
                    else -> {
                        goUp(cctv, copied)
                    }
                }
            } else if (board[y][x] == 2) {
                if (dir == 0 || dir == 2) {
                    goLeft(cctv, copied)
                    goRight(cctv, copied)
                } else {
                    goUp(cctv, copied)
                    goDown(cctv, copied)
                }
            } else if (board[y][x] == 3) {
                when (dir) {
                    0 -> {
                        goUp(cctv, copied)
                        goRight(cctv, copied)
                    }
                    1 -> {
                        goRight(cctv, copied)
                        goDown(cctv, copied)
                    }
                    2 -> {
                        goDown(cctv, copied)
                        goLeft(cctv, copied)
                    }
                    else -> {
                        goLeft(cctv, copied)
                        goUp(cctv, copied)
                    }
                }
            } else if (board[y][x] == 4) {
                when (dir) {
                    0 -> {
                        goUp(cctv, copied)
                        goLeft(cctv, copied)
                        goRight(cctv, copied)
                    }
                    1 -> {
                        goUp(cctv, copied)
                        goRight(cctv, copied)
                        goDown(cctv, copied)
                    }
                    2 -> {
                        goRight(cctv, copied)
                        goDown(cctv, copied)
                        goLeft(cctv, copied)
                    }
                    else -> {
                        goLeft(cctv, copied)
                        goDown(cctv, copied)
                        goUp(cctv, copied)
                    }
                }
            } else {
                goRight(cctv, copied)
                goDown(cctv, copied)
                goUp(cctv, copied)
                goLeft(cctv, copied)
            }
        }

        var cnt = 0
        for (y in 0 until n) {
            for (x in 0 until m) {
                if (copied[y][x] == 0) {
                    cnt += 1
                }
            }
        }

        return cnt
    }

    fun bt(cursor: Int) {
        if (cursor == cctvs.size) {
            val tmp = count()
            if (tmp < min) {
                min = tmp
            }
            return
        }

        for (idx in 0 until 4) {
            direction[cursor] = idx
            bt(cursor + 1)
        }
    }

    bt(0)

    println(min)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }


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