package kata.roman

/**
 * Converts the given [nr] to its [roman representation](https://en.wikipedia.org/wiki/Roman_numerals)
 */
fun roman(nr: Int): String {
    val initial = Number(nr % 1000, List(nr / 1000) { 'M' })
    val solved = digitConverters.fold(initial, Number::convertWith)
    return String(solved.chars.toCharArray())
}

private class Number(
    val decimal: Int,
    val chars: List<Char>
) {
    fun convertWith(converter: DigitConverter): Number {
        val digit = decimal / converter.factor
        val rest = decimal % converter.factor
        return Number(rest, chars + converter.toRoman(digit))
    }
}

private val convertOne = DigitConverter('X', 'V', 'I', 1)
private val convertTen = DigitConverter('C', 'L', 'X', 10)
private val convertHundred = DigitConverter('M', 'D', 'C', 100)
private val digitConverters = listOf(convertHundred, convertTen, convertOne)

private class DigitConverter(
    val x: Char,
    val v: Char,
    val i: Char,
    val factor: Int
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
