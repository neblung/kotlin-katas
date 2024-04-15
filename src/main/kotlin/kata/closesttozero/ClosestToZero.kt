package kata.closesttozero

fun List<Int>.closestToZero(): Int {
    return reduce(::closerToZero)
}

internal fun closerToZero(a: Int, b: Int): Int {
    return minOf(a, b)
}
