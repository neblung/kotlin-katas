package kata.roman

/**
 * Converts the given [nr] to its [roman representation](https://en.wikipedia.org/wiki/Roman_numerals)
 */
fun roman(nr: Int): String {
    val initial = Number(nr, listOf())
    val solved = initial.convertWith(convertHundred, 100)
        .convertWith(convertTen, 10)
        .convertWith(convertOne, 1)
    val chars = solved.chars
    return String(chars.toCharArray())
}

private class Number(
    val decimal: Int,
    val chars: List<Char>
) {
    fun convertWith(converter: DigitConverter, factor: Int): Number {
        val digit = decimal / factor
        val rest = decimal % factor
        return Number(rest, chars + converter.toRoman(digit))
    }
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
