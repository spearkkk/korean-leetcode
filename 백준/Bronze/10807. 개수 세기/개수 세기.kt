fun main() {
    val n = readln().toInt()

    val numbers = readln().split(" ").map { it.toInt() }
    val target = readln().toInt()

    var answer = 0
    for (i in 0..< n) {
        if (target == numbers[i]) {
            answer += 1
        }
    }
    println(answer)
}
