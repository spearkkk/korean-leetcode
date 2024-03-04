fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    /**
     * ref.) https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x14/solutions/13144.cpp
     */
    val n = readInt()
    val numbers = readInts()

    val holder = mutableSetOf<Int>()

    var left = 0
    var right = 0

    var answer = 0L

    holder.add(numbers[0])

    while (left < n) {
        while (right < n - 1 && !holder.contains(numbers[right + 1])) {
            right += 1
            holder.add(numbers[right])
        }

        answer += (right - left + 1)

        holder.remove(numbers[left])
        left += 1
    }
    println(answer)
}