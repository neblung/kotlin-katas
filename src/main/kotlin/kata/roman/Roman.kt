package kata.roman

/**
 * Converts the given [nr] to its [roman representation](https://en.wikipedia.org/wiki/Roman_numerals)
 */
fun roman(nr: Int): String = when (nr) {
    1 -> "I"
    2 -> "II"
    3 -> "III"
    4 -> "IV"
    5 -> "V"
    6 -> "VI"
    7 -> "VII"
    8 -> "VIII"
    9 -> "IX"

    10 -> "X"
    20 -> "XX"
    30 -> "XXX"
    40 -> "XL"
    50 -> "L"
    60 -> "LX"
    70 -> "LXX"
    80 -> "LXXX"
    90 -> "XC"
    else -> error(nr)
}
