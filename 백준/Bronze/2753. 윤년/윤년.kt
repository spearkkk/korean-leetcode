import java.io.*


fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)
//fun readBigDecimal(separator: Char = ' ') = readLine()!!.split(separator).map(String::toDouble).map(BigDecimal::valueOf)

fun main(args: Array<String>) {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val year = readLine()!!.toLong()

    if (year % 400 == 0L) {
        writer.write("1")
    }
    else if (year % 100 == 0L) {
        writer.write("0")
    }
    else if (year % 4 == 0L) {
        writer.write("1")
    }
    else {
        writer.write("0")
    }

    writer.flush()
}