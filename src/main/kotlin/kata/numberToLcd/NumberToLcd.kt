package kata.numberToLcd

/**
 * See https://codingdojo.org/kata/NumberToLCD/
 */
object NumberToLcd {
    fun convert(number: Int): List<String> {
        return sevenSegments[number]
    }

    internal fun Int.toDigits(): List<Int> {
        val result = mutableListOf<Int>()
        var rest = this
        while (rest >= 10) {
            result += rest % 10
            rest /= 10
        }
        result.add(rest)
        return result.reversed()
    }
}

private val sevenSegments = listOf(
    listOf(
        " _ ",
        "| |",
        "|_|",
    ),
    listOf(
        "   ",
        "  |",
        "  |",
    ),
    listOf(
        " _ ",
        " _|",
        "|_ ",
    ),
    listOf(
        " _ ",
        " _|",
        " _|",
    ),
    listOf(
        "   ",
        "|_|",
        "  |",
    ),
    listOf(
        " _ ",
        "|_ ",
        " _|",
    ),
    listOf(
        " _ ",
        "|_ ",
        "|_|",
    ),
    listOf(
        " _ ",
        "  |",
        "  |",
    ),
    listOf(
        " _ ",
        "|_|",
        "|_|",
    ),
    listOf(
        " _ ",
        "|_|",
        " _|",
    ),
)
