fun main() {
    val n = readInt()

    /**
     * 
     * 음수가 2개 이상이면 작은 음수 2개를 골라 곱해서 더한다. -> 이보다 높은 값을 조합하는 방법은 없음
     * 음수가 짝수이면 위와 같은 로직으로  다 커버 가능
     * 그러나 음수가 홀수 이면 짝수개를 위와 같이 처리한다해도 하나의 값이 음수로 남아있음
     * 그렇기 때문에 음수가 홀수 이면 예외처리를 해줘야함
     * 음수가 홀수 일때 최대 값을 내는 방법은 0의 존재 유무임
     * 0이 존재하면 0을 이용해서 음수를 없앨 수 있음
     * 0이 없다면 어쩔 수 없이 해당 음수를 더해야함.
     * --- 여기까지가 음수 와 0을 이용한 최대 합을 구하는 로직
     * 
     * 양수일 때는 간단함, 정렬해서 2개의 수를 곱하면 됨.
     * 단, 예제에서 볼 수 있듯이 1일 경우는 조금 다름.
     * 두 양수 중 하나라도 1이 포함되었다면 곱하는 것보다 더하는것이 최대 합임.
     * 1 * n < n + 1( n >= 1) : 이 수식은 자명함..
     * 
     */
    val minus = mutableListOf<Long>()
    val plus = mutableListOf<Long>()
    var zeroExist = false

    repeat(n) {
        val tmp = readLong()

        if (tmp == 0L) {
            zeroExist = true

        } else if (tmp < 0) {
            minus.add(tmp)
        } else {
            plus.add(tmp)
        }
    }

    minus.sort()
    plus.sortDescending()

    var result = 0L

    for (i in 0 until minus.size / 2) {
        result += minus[2 * i] * minus[2 * i + 1]
        minus[2 * i] = 0
        minus[2 * i + 1] = 0
    }

    val leftMinus = minus.sum()
    if (leftMinus < 0 && !zeroExist) {
        result += leftMinus
    }

    for (i in 0 until plus.size / 2) {
        if (plus[2 * i] != 1L && plus[2 * i + 1] != 1L) {
            result += plus[2 * i] * plus[2 * i + 1]
            plus[2 * i] = 0
            plus[2 * i + 1] = 0
        }
    }

    result += plus.sum()
    println(result)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }