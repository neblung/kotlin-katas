package kata.combinednumber

internal fun compare(a: Int, b: Int): Int {
    return "$a$b".compareTo("$b$a")
}

fun List<Int>.combine(): String = sortedWith(::compare).reversed().joinToString("")
