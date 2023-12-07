import java.lang.StringBuilder

fun main() {
    val (L, C) = readInts()

    val alphabets = readStr().split(" ").toTypedArray().sortedArray()

    val answer = mutableListOf<String>()
    val sb = StringBuilder()

    var aCnt = 0
    var bCnt = 0

    val aHolder = setOf("a", "e", "i", "o", "u")

    fun bt(cursor: Int, cnt: Int) {
        if (cnt == L) {
            if (aCnt >= 1 && bCnt >= 2){
                sb.append(answer.joinToString("") + "\n")
            }
            return
        }

        if (cursor == C) {
            return
        }

        answer.add(alphabets[cursor])
        if (aHolder.contains(alphabets[cursor])) {
            aCnt += 1
        } else {
            bCnt += 1
        }
        bt(cursor + 1, cnt + 1)

        answer.removeLast()
        if (aHolder.contains(alphabets[cursor])) {
            aCnt -= 1
        } else {
            bCnt -= 1
        }
        bt(cursor + 1, cnt)
    }

    bt(0, 0)

    println(sb)

}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }