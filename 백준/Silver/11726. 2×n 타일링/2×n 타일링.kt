fun main() {
    val n = readInt()
    
    if (n <= 2) {
        println(n)
        return
    }
    
    val s = IntArray(n + 1) 
    s[1] = 1
    s[2] = 2
    
    for (k in 3 .. n) {
        s[k] = (s[k - 1] + s[k - 2]) % 10007 
    }
    
    println(s[n])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }