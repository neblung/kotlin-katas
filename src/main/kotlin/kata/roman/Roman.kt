package kata.roman

/**
 * Converts the given [nr] to its [roman representation](https://en.wikipedia.org/wiki/Roman_numerals)
 */
fun roman(nr: Int): String {
    val chars: List<Char> =
        if (nr < 10) convertOne.toRoman(nr)
        else convertTen.toRoman(nr / 10)
    return String(chars.toCharArray())
}

private val convertOne = DigitConverter('X', 'V', 'I')
private val convertTen = DigitConverter('C', 'L', 'X')

private class DigitConverter(
    val x: Char,
    val v: Char,
    val i: Char,
) {
    fun toRoman(digit: Int) = when (digit) {
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
