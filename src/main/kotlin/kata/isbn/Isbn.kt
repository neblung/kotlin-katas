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

private fun checkIsbn13(str: String): Boolean {
    fun factor(index: Int) = if ((index and 1) == 0) 1 else 3
    // str is already normalized
    val sum = str.dropLast(1).withIndex().sumOf { (index, c) -> factor(index) * c.digitToInt() }
    val actualCheckDigit = (10 - (sum % 10)) % 10
    return actualCheckDigit == str.last().digitToInt()
}
