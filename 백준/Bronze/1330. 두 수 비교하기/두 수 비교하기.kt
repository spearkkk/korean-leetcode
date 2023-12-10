import java.io.*


fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)
//fun readBigDecimal(separator: Char = ' ') = readLine()!!.split(separator).map(String::toDouble).map(BigDecimal::valueOf)

fun main(args: Array<String>) {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val list = readInts()

    if (list[0] > list[1])
        writer.write(">")
    else if (list[0] < list[1])
        writer.write("<")
    else
        writer.write("==")

    writer.flush()
}