fun main() {
    val numberToLevel = HashMap<Int, Int>()
    val levelToNumbers = java.util.TreeMap<Int, java.util.TreeSet<Int>>()

    repeat(readInt()) {
        val (number, level) = readInts()

        numberToLevel[number] = level

        val numbers = levelToNumbers.getOrDefault(level, java.util.TreeSet<Int>())
        numbers.add(number)
        levelToNumbers[level] = numbers
    }

    val sb = StringBuilder()
    repeat(readInt()) {
        val line = readStrings()
        when(line[0]) {
            "recommend" -> {
                if (line[1] == "1") {
                    sb.append(levelToNumbers.lastEntry().value.last())
                    sb.appendLine()
                } else {
                    sb.append(levelToNumbers.firstEntry().value.first())
                    sb.appendLine()
                }
            }
            "add" -> {
                val number = line[1].toInt()
                val level = line[2].toInt()

                numberToLevel[number] = level

                val numbers = levelToNumbers.getOrDefault(level, java.util.TreeSet<Int>())
                numbers.add(number)
                levelToNumbers[level] = numbers
            }
            else -> {
                val number = line[1].toInt()
                val level = numberToLevel[number]!!

                val numbers = levelToNumbers[level]!!
                numbers.remove(number)
                if (numbers.isEmpty()) {
                    levelToNumbers.remove(level)
                } else {
                    levelToNumbers[level] = numbers
                }

                numberToLevel.remove(number)
            }
        }
    }
    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }