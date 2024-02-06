package kata.numberToLcd

/**
 * See https://codingdojo.org/kata/NumberToLCD/
 */
object NumberToLcd {
    fun convert(number: Int): List<String> {
        return number.toDigits()
            .map { sevenSegments[it] }
            .reduce(::blockJoin)
    }

    // VisibleForTesting
    internal fun Int.toDigits(): List<Int> = toString().map { it - '0' }

    // VisibleForTesting
    internal fun blockJoin(left: List<String>, right: List<String>): List<String> {
        return left.mapIndexed { index, prefix -> prefix + right[index] }
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
