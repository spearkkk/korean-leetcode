package spearkkk.acmicpc.no_1002

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * distance == 0,
 *  r1 == r2 -> -1
 *  r1 != r2 -> 0
 * distance > 0
 *  distance < |r1 - r2| -> 0
 *  distance == |r1 - r2| -> 1
 *  distance > |r1 - r2| && distance < |r1 + r2| -> 2
 *  distance == |r1 + r2| -> 1
 *  distance > |r1 + r2| -> 0
 */
fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine()!!.toInt()

    for ( i in 1 .. t) {
        val splits = readLine()!!.split(" ").map { it.toInt() }
        val x1 = splits[0]
        val y1 = splits[1]
        val r1 = splits[2]

        val x2 = splits[3]
        val y2 = splits[4]
        val r2 = splits[5]

        val xGap = abs(x1 - x2)
        val yGap = abs(y1 - y2)
        val distance = xGap * xGap + yGap * yGap
        var sum = r1 + r2
        sum *= sum
        var diff =r2 - r1
        diff *= diff

        if (distance == 0) {
            if (r1 == r2) writer.write("-1")
            else writer.write("0")
        } else {
            when {
                distance > sum -> writer.write("0")
                distance == sum -> writer.write("1")
                distance > diff && diff < sum -> writer.write("2")
                distance == diff -> writer.write("1")
                distance < diff -> writer.write("0")
            }
        }
        writer.newLine()
        writer.flush()
    }
}