fun main() {
    val sb = StringBuilder()
    repeat(readInt()) {
        val n = readInt()
        val numbers = readLongs()

        /**
         * 전형적인 그리디 알고리즘 문제
         * 내가 주식을 팔 수 있는 순간은 최대 가격차이가 나는 순간이다.
         * 
         * 뒤에서부터 최댓값을 찾아 각 날마다 저장한다.
         * 다만, 뒤에서부터 시작하는 이유는 해당 날짜보다 앞에 있는 최댓갑은 사용할 수 없기 때문이다.
         * 결과적으로 해당 날짜에서부터 미래에 올 최댓값을 안다면 해당 날짜에 주식을 사서 최댓값을 만나는 날짜에 팔아버린다.
         * 
         * 타입을 long으로 해야 성공한다.
         */
        val maxNumbers = LongArray(n)

        maxNumbers[n - 1] = numbers[n - 1]
        var currentMax = numbers[n - 1]
        for (i in n - 2 downTo 0) {
            if (currentMax < numbers[i]) {
                currentMax = numbers[i]
            }
            maxNumbers[i] = currentMax
        }

        var answer = 0L
        for (i in 0 until n) {
            answer += maxNumbers[i] - numbers[i]
        }
        sb.append(answer)
        sb.appendLine()
    }
    print(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }