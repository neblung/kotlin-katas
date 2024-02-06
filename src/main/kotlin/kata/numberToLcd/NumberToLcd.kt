package kata.numberToLcd

/**
 * See https://codingdojo.org/kata/NumberToLCD/
 */
object NumberToLcd {
    fun convert(number: Int): List<String> {
        return sevenSegments[number]
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
