fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val (n, m) = readInts()
    val numbers = readInts()

    var left = 0
    var right = 0
    var sum = numbers[left]

    var answer = 0
    while (left < n) {
        while (right < n - 1 && sum < m) {
            right += 1
            sum += numbers[right]
        }

        if (sum == m) {
            answer += 1
        }

//        println("left: $left, right: $right, sum: $sum, m: $m, answer: $answer")
        sum -= numbers[left]
        left += 1
    }
    println(answer)
}