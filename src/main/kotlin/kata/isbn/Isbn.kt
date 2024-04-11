package kata.isbn

/**
 * Removes spaces and hyphens as they are to be ignored.
 */
internal fun normalize(str: String): String {
    return str.replace(" ", "").replace("-", "")
}

/**
 * Checks if this String is a valid ISBN-13 or ISBN-10
 */
fun String.isIsbn() = isIsbn10() || isIsbn13()

/**
 * Checks if this String is a valid ISBN-13
 */
fun String.isIsbn13(): Boolean {
    val normalized = normalize(this)
    return normalized.length == 13 && normalized.all { it.isDigit() } && checkIsbn13(normalized)
}

private fun checkIsbn13(normalized: String): Boolean {
    fun factor(index: Int) = if ((index and 1) == 0) 1 else 3
    val sum = normalized.dropLast(1).withIndex().sumOf { (index, c) -> factor(index) * c.digitToInt() }
    val actualCheckDigit = (10 - (sum % 10)) % 10
    return actualCheckDigit == normalized.last().digitToInt()
}

/**
 * Checks if this String is a valid ISBN-10
 */
fun String.isIsbn10(): Boolean {
    val normalized = normalize(this)
    return normalized.length == 10 && checkIsbn10Syntax(normalized) && checkIsbn10Digit(normalized)
}

private fun checkIsbn10Syntax(normalized: String): Boolean {
    return normalized.dropLast(1).all { it.isDigit() } && normalized.last().let { it.isDigit() || it == 'X' }
}

private fun checkIsbn10Digit(normalized: String): Boolean {
    fun factor(index: Int) = index + 1
    val sum = normalized.dropLast(1).withIndex().sumOf { (index, c) -> factor(index) * c.digitToInt() }
    val actualCheckDigit = (sum % 11).takeIf { it in 0..9 }?.digitToChar() ?: 'X'
    return actualCheckDigit == normalized.last()
}
