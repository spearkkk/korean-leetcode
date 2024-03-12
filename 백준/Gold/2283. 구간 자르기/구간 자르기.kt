
fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    /**
     * 0 8 -> 2 9 => 2 8 -> 6
     * 0 10 -> 2 9 => 2 9 -> 7
     * 3 10 -> 2 9 => 3 9 -> 6
     * 3 15 -> 2 9 => 3 9 -> 6
     *
     */
    val (n, k) = readInts()

    val startPoints = mutableMapOf<Int, Int>()
    val endPoints = mutableMapOf<Int, Int>()

    var min = 1_000_000
    var max = 0

    repeat(n) {
        val (start, end) = readInts()
        startPoints[start] = startPoints.getOrDefault(start, 0) + 1
        endPoints[end] = endPoints.getOrDefault(end, 0) + 1

        if (max < end) {
            max = end
        }
        if (start < min) {
            min = start
        }
    }

    val left = min
    val right = max + 1

    val numbers = IntArray(right)
    val sum = IntArray(right)

    for (i in 1 until right) {
        numbers[i] = startPoints.getOrDefault(i - 1, 0) + numbers[i - 1] - endPoints.getOrDefault(i - 1, 0)
        sum[i] = sum[i - 1] + numbers[i]
    }

//    println(numbers.joinToString(" "))
//    println(sum.joinToString(" "))

    var a = 0
    var b = left

    while (a < right) {
        while (b < right && sum[b] - sum[a] < k) {
            b += 1
        }

        if (b >= right) {
            break
        }

        if (sum[b] - sum[a] == k) {
            println("$a $b")
            return
        }

        a += 1
    }
    println("0 0")
}