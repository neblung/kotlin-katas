package kata.isbn

/**
 * Removes spaces and hyphens as they are to be ignored.
 */
fun normalize(str: String): String {
    return str.replace(" ", "").replace("-", "")
}

fun String.isIsbn13(): Boolean {
    val normalized = normalize(this)
    return normalized.length == 13 && normalized.all { it.isDigit() }
}
