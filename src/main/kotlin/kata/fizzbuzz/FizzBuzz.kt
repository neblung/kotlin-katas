package kata.fizzbuzz

fun fizzbuzz(number: Int): String {
    val fizz = isFizz(number)
    val buzz = isBuzz(number)
    return fizzBuzzString(fizz, buzz) { number.toString() }
}

internal fun isFizz(number: Int) = number.isDividableBy(3) or number.containsDigit(3)
internal fun isBuzz(number: Int) = number.isDividableBy(5) or number.containsDigit(5)

private fun Int.isDividableBy(denominator: Int) = this % denominator == 0
private fun Int.containsDigit(candidate: Int) = toString().contains(candidate.digitToChar())

internal fun fizzBuzzString(fizz: Boolean, buzz: Boolean, neitherNorProvider: () -> String): String {
    return when {
        fizz and buzz -> "FizzBuzz"
        fizz -> "Fizz"
        buzz -> "Buzz"
        else -> neitherNorProvider()
    }
}
