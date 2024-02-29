fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

typealias IdxToNumber = Pair<Int, Int>

fun main() {
    /**
     * 현재 위치보다 오른쪽에 위치하고 현재 위치의 값보다 큰 값을 가진다.
     * 그런 값들 중에 가장 왼쪽에 위치한 값을 오큰수라고 한다.
     * 그런 값이 없으면 -1를 저장한다. -> default 값을 -1로 둔다.
     *
     * 데이터를 저장할 때, 가장 마지막에 저장한 값이 현재 값보다 크다 -> 마지막에 해당 데이터를 저장한다.
     * 데이터를 저장할 때, 가장 마지막에 저장한 값이 현재 값보다 작다 -> 마지막 값을 빼고 오큰수를 입력한다. 위의 조건이 나올 때까지 반복
     */
    val stack = mutableListOf<IdxToNumber>()
    val n = readInt()
    val numbers = readInts()

    val answers = IntArray(n) { -1 }

    for ((it, number) in numbers.withIndex()) {

        while (stack.isNotEmpty() && stack.last().second < number) {
            val last = stack.removeLast()
            answers[last.first] = number
        }
        stack.add(IdxToNumber(it, number))
    }

    println(answers.joinToString(" "))
}