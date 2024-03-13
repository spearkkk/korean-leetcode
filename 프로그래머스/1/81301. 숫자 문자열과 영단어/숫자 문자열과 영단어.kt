class Solution {
    private val array: Array<String> = arrayOf(
        "zero",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    )

    fun solution(s: String): Int {
        var answer: Int = 0

        var cursor = 0

        while (cursor < s.length) {
            val c = s[cursor]
            val n = c.code - '0'.code
            if (n in 0 .. 9) {
                answer = answer * 10 + n
                cursor += 1
                continue
            }

            for (i in 0 until 10) {
                val candidate = array[i]
                if (s.length < candidate.length + cursor) {
                    continue
                }
                if (candidate != s.slice(cursor until cursor + candidate.length)) {
                    continue
                }
                answer = answer * 10 + i
                break
            }
            cursor += 1
        }

        return answer
    }
}