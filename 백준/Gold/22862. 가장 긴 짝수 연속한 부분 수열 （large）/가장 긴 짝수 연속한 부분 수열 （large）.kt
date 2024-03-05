fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val (n, k) = readInts()
    val numbers = readInts()

    var left = 0
    var right = 0

    var max = 0

    var cnt = 0
    while (left < n) {
        while (right < n) {
            if (numbers[right] % 2 == 0) {
                right += 1
                continue
            }
            if (cnt == k) {
                break
            }
            cnt += 1
            right += 1
        }

        max = kotlin.math.max(max, right - left - cnt)

//        println("left: $left, right: $right, cnt: $cnt, k: $k, max: $max")

        cnt -= if (numbers[left] % 2 == 0) 0 else 1
        left += 1
    }
    println(max)
}