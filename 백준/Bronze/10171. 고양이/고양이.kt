import java.io.*

fun main(args: Array<String>) {
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val cat = "\\    /\\\n" + " )  ( ')\n" + "(  /  )\n" + " \\(__)|"

    writer.write(cat)

    writer.flush()
}