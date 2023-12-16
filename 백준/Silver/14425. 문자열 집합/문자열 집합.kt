fun main() {
    val (n, m) = readInts()
    
    val set = HashSet<String>()
    repeat(n) {
        set.add(readStr())
    }
    
    var cnt = 0
    repeat(m) {
        if (set.contains(readStr())) {
            cnt += 1
        }
    }
    println(cnt)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }