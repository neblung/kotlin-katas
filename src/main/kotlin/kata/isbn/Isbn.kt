package kata.isbn

/**
 * Removes spaces and hyphens as they are to be ignored.
 */
fun normalize(str: String): String {
    return str.replace(" ", "").replace("-", "")
}
