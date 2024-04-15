package kata.closesttozero

import kotlin.math.abs

fun List<Int>.closestToZero(): Int {
    return reduce(::closerToZero)
}

internal fun closerToZero(a: Int, b: Int): Int {
    return when {
        abs(a) < abs(b) -> a
        abs(a) == abs(b) && a > 0 -> a
        else -> b
    }
}
