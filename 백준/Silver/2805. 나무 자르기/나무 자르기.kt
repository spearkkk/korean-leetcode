fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val heights = readln().split(" ").map { it.toInt() }.sorted()

//    println("n: $n, m: $m")
//    println("heights: $heights")

    var bottom = 0
    var top = heights[heights.size - 1]
    var answer = 0

    while (bottom <= top) {
        val middle = (bottom + top) / 2

        var currentM = 0L
        for (height in heights) {
            if (height > middle) {
                currentM += height - middle
            }
        }
//        println("bottom: $bottom, top: $top, middle: $middle, m: $m, currentM: $currentM")

        if (currentM >= m) {
            answer = middle

            bottom = middle + 1
        } else {
            top = middle - 1
        }
    }

    println(answer)
}