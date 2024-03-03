fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val (n, s) = readInts()
    val numbers = readInts()

    var left = 0
    var right = 0

    var sum = numbers[left] // 초기 합
    var l = Int.MAX_VALUE

    while (left < n) {
        // 현재 합이 목표 합보다 작으면 right 커서를 오른쪽으로 이동한 후, 더한다.
        while (right < n - 1 && sum < s) {
            right += 1
            sum += numbers[right]
        }

        if (sum >= s){
            l = kotlin.math.min(l, right - left + 1)
        }

//        println("left: $left, right: $right, sum: $sum, l: $l")

        // left 커서도 오른쪽으로 이동하기 때문에 현재 합에서 값을 빼야 한다.
        sum -= numbers[left]
        left += 1
    }

    println(if (l == Int.MAX_VALUE) 0 else l)
}