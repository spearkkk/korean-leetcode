fun main() {
    val n = readInt()
    val citations = readInts().toIntArray()
    val papers = IntArray(citations.size + 1) { 0 }

    for (citation in citations) {
        papers[kotlin.math.min(n, citation)] += 1
    }

    var k = n
    var s = papers[n]
    while (k > s) {
        k -= 1
        s += papers[k]
    }
    println(k)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }