fun main() {
    // https://youtu.be/Enz2csssTCs?si=zq4w3Oa7MQAhrmwQ
    val n = readInt()

    val array1 = BooleanArray(n) { false }
    val array2 = BooleanArray(2 * (n - 1) + 1) { false }
    val array3 = BooleanArray(2 * (n - 1) + 1) { false }

    var count = 0
    fun bt(x: Int) {
        if (x == n) {
            count += 1
            return
        }

        for (y in 0 until n) {
            if (array1[y] || array2[y + x] || array3[y + (n - 1) - x]) {
                continue
            }

            array1[y] = true
            array2[y + x] = true
            array3[y + (n - 1) - x] = true

            bt(x + 1)

            array1[y] = false
            array2[y + x] = false
            array3[y + (n - 1) - x] = false
        }
    }

    bt(0)

    println(count)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }