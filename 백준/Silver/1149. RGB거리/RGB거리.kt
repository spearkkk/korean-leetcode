package spearkkk.acmicpc.no_1149

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val redCosts = IntArray(1001){ 0 }
    val greenCosts = IntArray(1001){ 0 }
    val blueCosts = IntArray(1001){ 0}

    val red = IntArray(1001){ 0 }
    val green = IntArray(1001){ 0 }
    val blue = IntArray(1001){ 0 }

    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val eachCosts = readLine()!!.split(" ").map(String::toInt)
        redCosts[i] = eachCosts[0]
        greenCosts[i] = eachCosts[1]
        blueCosts[i] = eachCosts[2]
    }

    red[1] = redCosts[1]
    green[1] = greenCosts[1]
    blue[1] = blueCosts[1]

    for (i in 2..n) {
        red[i] = redCosts[i] + min(green[i - 1], blue[i - 1])
        green[i] = greenCosts[i] + min(red[i - 1], blue[i - 1])
        blue[i] = blueCosts[i] + min(red[i - 1], green[i - 1])
    }

    writer.write("${min(min(red[n], blue[n]), green[n])}")
    writer.newLine()
    
    writer.flush()
}