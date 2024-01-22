fun main() {
    val heights = IntArray(9)
    val dwarfs = BooleanArray(9) { true }
    repeat(9) {
        heights[it] = readInt()
    }
//    println(heights.joinToString(" "))
    val overHeight = heights.sum() - 100

    var flg = false
    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            if (heights[i] + heights[j] == overHeight) {
                dwarfs[i] = false
                dwarfs[j] = false
                flg = true
            }
            if (flg) {
                break
            }
        }
        if (flg) {
            break
        }
    }

    println(heights.withIndex().filter { dwarfs[it.index] }.map { it.value }.sorted().joinToString("\n"))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }