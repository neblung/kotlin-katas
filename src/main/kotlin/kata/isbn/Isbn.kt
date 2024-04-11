package kata.isbn

/**
 * Removes spaces and hyphens as they are to be ignored.
 */
fun normalize(str: String): String {
    return str.replace(" ", "").replace("-", "")
}

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

fun String.isIsbn10(): Boolean {
    val normalized = normalize(this)
    return normalized.length == 10 && checkIsbn10Syntax(normalized) && checkIsbn10Digit(normalized)
}

fun checkIsbn10Syntax(normalized: String): Boolean {
    return normalized.dropLast(1).all { it.isDigit() } && normalized.last().let { it.isDigit() || it == 'X' }
}

fun checkIsbn10Digit(normalized: String): Boolean {
    fun factor(index: Int) = index + 1
    val sum = normalized.dropLast(1).withIndex().sumOf { (index, c) -> factor(index) * c.digitToInt() }
    val actualCheckDigit = (sum % 11).takeIf { it in 0..9 }?.digitToChar() ?: 'X'
    return actualCheckDigit == normalized.last()
}
