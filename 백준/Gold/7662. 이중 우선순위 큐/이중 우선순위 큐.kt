fun main() {
    repeat(readInt()) {
        val iToCnt = java.util.TreeMap<Int, Int>()

        fun minusIfExist(key: Int) {
            if (iToCnt.contains(key)) {
                val v = iToCnt[key]!! - 1
                if (v == 0) {
                    iToCnt.remove(key)
                } else {
                    iToCnt[key] = v
                }
            }
        }

        repeat(readInt()) {
            val (c, k) = readStrings()
            when (c) {
                "I" -> {
                    iToCnt[k.toInt()] = iToCnt.getOrDefault(k.toInt(), 0) + 1
                }
                "D" -> {
                    if (iToCnt.isNotEmpty()) {
                        if (k.toInt() == 1) {
                            minusIfExist(iToCnt.lastKey())
                        } else {
                            minusIfExist(iToCnt.firstKey())
                        }
                    }
                }
            }
        }
        println(if (iToCnt.isEmpty()) "EMPTY" else "${iToCnt.lastKey()} ${iToCnt.firstKey()}")
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }