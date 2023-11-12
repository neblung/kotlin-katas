package kata.roman

/**
 * Converts the given [nr] to its [roman representation](https://en.wikipedia.org/wiki/Roman_numerals)
 */
fun roman(nr: Int): String {
    var factor = nr / 100
    var rest = nr % 100

    val rC = convertHundred.toRoman(factor)
    factor = rest / 10
    rest = rest % 10
    val rX = convertTen.toRoman(factor)
    val rI = convertOne.toRoman(rest)
    val chars = rC + rX + rI

    return String(chars.toCharArray())
}

private val convertOne = DigitConverter('X', 'V', 'I')
private val convertTen = DigitConverter('C', 'L', 'X')
private val convertHundred = DigitConverter('M', 'D', 'C')

private class DigitConverter(
    val x: Char,
    val v: Char,
    val i: Char,
) {
    fun toRoman(digit: Int) = when (digit) {
        0 -> emptyList()
        1 -> listOf(i)
        2 -> listOf(i, i)
        3 -> listOf(i, i, i)
        4 -> listOf(i, v)
        5 -> listOf(v)
        6 -> listOf(v, i)
        7 -> listOf(v, i, i)
        8 -> listOf(v, i, i, i)
        9 -> listOf(i, x)
        else -> error(digit)
    }
}
