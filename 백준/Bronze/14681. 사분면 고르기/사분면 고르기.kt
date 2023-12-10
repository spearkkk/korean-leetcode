package spearkkk.acmicpc.no_14681

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val x = readLine()!!.toInt()
    val y = readLine()!!.toInt()

    if ( x > 0) {
        if (y > 0) writer.write("1")
        else writer.write("4")
    } else {
        if (y > 0) writer.write("2")
        else writer.write("3")
    }

    writer.newLine()
    writer.flush()
}