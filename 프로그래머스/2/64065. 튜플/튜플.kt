class Solution {
    private fun toList(s: String): List<Int> {
        return s
            .split(",")
            .map { it.toInt() }
    }

    private fun parse(s: String): List<List<Int>> {
        val holder = arrayListOf<List<Int>>()
        for (elem in s.slice(2 until s.length - 2).split("},{")) {
            holder.add(toList(elem))
        }
        return holder
    }

    fun solution(s: String): IntArray {

        val answer = mutableListOf<Int>()

        for (elem in parse(s).sortedBy { it.size }) {
            answer.add(elem.find { !answer.contains(it) }!!)
        }

        return answer.toIntArray()
    }
}