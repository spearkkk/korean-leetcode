fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val n = readInt()
    val raw = readInts()
    val numbers = raw.sorted()

    val nToCnt = mutableMapOf<Int, Int>()
    val nToCntOfSmaller = mutableMapOf<Int, Int>()
    for (i in numbers.indices) {
        nToCnt[numbers[i]] = nToCnt.getOrDefault(numbers[i], 0) + 1
        if (i == 0 || numbers[i - 1] == numbers[i]) {
            continue
        }

//        println("numbers[i - 1]: ${numbers[i - 1]}, nToCnt[numbers[i - 1]]: ${nToCnt[numbers[i - 1]]}, nToCntOfSmaller[numbers[i - 1]]: ${nToCntOfSmaller[numbers[i - 1]]}")
        nToCntOfSmaller[numbers[i]] = (if (nToCnt.contains(numbers[i - 1])) 1 else 0) + (nToCntOfSmaller[numbers[i - 1]] ?: 0)
    }

    val ans = StringBuilder()
    for (r in raw) {
        ans.append(nToCntOfSmaller[r] ?: 0).append(" ")
    }
    println(ans)
}