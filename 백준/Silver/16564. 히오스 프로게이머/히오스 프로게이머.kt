fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val levels = IntArray(n)
    repeat(n) {
        levels[it] = readln().toInt()
    }

    levels.sort()

    var bottom = 0L
    var top = levels[n - 1].toLong()

    var answer = 0L

    while (bottom <= top) {
        val middle = (bottom + top) / 2L

        var currentK = 0L
        for (level in levels) {
            if (level < middle) {
                currentK += middle - level
            }
        }

        if (currentK <= k) {
            answer = middle

            bottom = middle + 1L
        } else {
            top = middle - 1L
        }
    }

    // edge case, k 다 소비해도 남은 k 가 있을 때
    var anotherK = k.toLong()
    for (level in levels) {
        if (answer > level) {
            anotherK -= answer - level
        }
    }

    println(answer + anotherK / n)
}