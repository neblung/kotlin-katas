package kata.numberToLcd

/**
 * See https://codingdojo.org/kata/NumberToLCD/
 */
object NumberToLcd {
    fun convert(number: Int, width: Int, height: Int): List<String> {
        return number.toDigits()
            .map { scale(sevenSegments[it], width, height) }
            .reduce(::blockJoin)
    }

    // VisibleForTesting
    internal fun Int.toDigits(): List<Int> = toString().map { it - '0' }

    // VisibleForTesting
    internal fun blockJoin(left: List<String>, right: List<String>): List<String> {
        return left.mapIndexed { index, prefix -> prefix + right[index] }
    }

    private fun scale(segments: List<String>, width: Int, height: Int): List<String> {
        val top = segments[0][1]
        val mid = segments[1][1]
        val bottom = segments[2][1]
        val upperLeft = segments[1][0]
        val upperRight = segments[1][2]
        val lowerLeft = segments[2][0]
        val lowerRight = segments[2][2]

        fun MutableList<String>.addLine(leftChar: Char, midChar: Char, rightChar: Char) =
            buildString {
                append(leftChar)
                repeat(width) { append(midChar) }
                append(rightChar)
            }.also { add(it) }

        return buildList {
            addLine(' ', top, ' ')
            repeat(height - 1) {
                addLine(upperLeft, ' ', upperRight)
            }
            addLine(upperLeft, mid, upperRight)
            repeat(height - 1) {
                addLine(lowerLeft, ' ', lowerRight)
            }
            addLine(lowerLeft, bottom, lowerRight)
        }
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
