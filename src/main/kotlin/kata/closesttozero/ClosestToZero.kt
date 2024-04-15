package kata.closesttozero

fun List<Int>.closestToZero(): Int {
    return reduce { a, b -> minOf(a, b) }
}
