fun main() {
    val n = readInt()

    /**
     * 두 개의 선이 서로 닿지 않으면 별개의 선이다.
     * from_1 < to_1 < from_2 < to_2
     *
     * 두 개의 선 중 하나가 다른 하나의 선을 포함하면 해당 선은 의미 없는 선이다.
     * from_1 <= from_2 < to_2 <= to_1 -> from_1 < to_1
     *
     * 두 개의 선이 서로 겹쳐있는 선은 연장되어 하나의 또 다른 선이 된다.
     * from_1 <= from_2 <= to_1 <= to_2 (from_1 < to_1, from_2 < to_2) -> from_1 < to_2
     *
     * 그렇다면 두 선을 선택할 때 어떻게 선택을 할 것인가?
     * 무작위로 처리해도 되는가?
     * 아니면 정렬을 해서 처리를 해야할까?
     *
     * 시작 지점이 같다면 제일 긴 선을 가지고 있어야한다. -> case 2
     * 시작 지점이 같은데 더 짧은 선을 처리한다면... 중복처리를 하게 된다...
     * 따라서 시작 지점이 작은 순, 길이가 제일 긴 순
     *
     * 서로 닿지 않은 선이 있었지만
     * 하나의 선이 점점 길이가 길어져 닿지 않았던 선과 닿을 수 있을 것인가?
     * 서로 닿지 않았다는 것은 시작 지점이 차이가 나는데...
     * 선은 뒤로만 확장이 되기 때문에 앞의 선이 뒤로 확장되어야 한다.
     * 뒤로 확장하기 위해서는 앞의 선과 겹쳐 있어야하는데 그 말은 즉슨 뒤의 선보다 시작 지점이 작은 선이 필요하다.
     * 그런데 이 선은 이미 처리가 되었을 것이다. 왜냐하면 선의 시작 지점이 작은 순으로 정렬했으니깐
     *
     * ==> 우선 순위 큐는 시간 초과
     *
     * 입력을 받을 때 마다 이미 넣은 선들과 입력 받은 선을 비교한다.
     * 합칠 수 있는 선이면 이미 넣은 그 선 대신 새로 합친 선을 넣는다.
     * 합칠 수 없는 선이면 이미 넣은 선들을 다 확인한 후, 마지막에 넣는다.
     *
     * ==> 틀렸습니다..왜 틀렸을까.. 자정작용이 필요하다.
     * 4
     * 1 10
     * 11 20
     * 21 30
     * 1 40
     *
     *
     */

    fun couldBeMerged(left: FromTo, right: FromTo): FromTo? {
        if (left.second < right.first) {
            return null
        }
        if (right.second < left.first) {
            return null
        }

        return FromTo(if (left.first <= right.first) left.first else right.first, if (left.second <= right.second) right.second else left.second)
    }



    fun tryMerge(originalLines: List<FromTo>): List<FromTo> {
        val lines = mutableListOf<FromTo>()

        for (line in originalLines) {
            val (from, to) = line

            if (lines.isEmpty()) {
                lines.add(line)
                continue
            }

            var flg = false
            var cur = 0
            while (cur < lines.size) {
                val fromTo: FromTo? = couldBeMerged(line, lines[cur])
                if (fromTo != null) {
                    lines[cur] = fromTo
                    flg = true
                    break
                }
                cur += 1
            }

            if (!flg) {
                lines.add(line)
            }
        }

        return lines
    }


    val originalLines = mutableListOf<FromTo>()
    for (i in 0 until n) {
        val (from, to) = readLongs()
        originalLines.add(FromTo(from, to))
    }

    while (true) {
        val lines = tryMerge(originalLines)
        if (lines.size == originalLines.size) {
            var sum = 0L
            for (line in lines) {
                val (from, to) = line
                sum += to - from
            }

            println(sum)
            return
        }
        originalLines.clear()
        originalLines.addAll(lines)
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }

typealias FromTo = Pair<Long, Long>