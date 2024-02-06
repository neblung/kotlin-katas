package kata.numberToLcd

/**
 * See https://codingdojo.org/kata/NumberToLCD/
 */
object NumberToLcd {
    fun convert(number: Int): List<String> {
        return listOf(
            " _ ",
            "| |",
            "|_|",
        )
    }
}
