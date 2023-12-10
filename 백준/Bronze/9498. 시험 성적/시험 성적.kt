import java.io.*

fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)
//fun readBigDecimal(separator: Char = ' ') = readLine()!!.split(separator).map(String::toDouble).map(BigDecimal::valueOf)

fun printString(str: String) {
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    writer.write(str)
}


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    when(n) {
        in 90..100 -> writer.write("A")
        in 80..89 -> writer.write("B")
        in 70..79 -> writer.write("C")
        in 60..69 -> writer.write("D")
        else -> writer.write("F")
    }

    writer.flush()
}