package kata.fizzbuzz

fun fizzbuzz(number: Int): String {
    val fizz = isFizz(number)
    val buzz = isBuzz(number)
    return fizzBuzzString(fizz, buzz) { number.toString() }
}

internal fun isFizz(number: Int) = number % 3 == 0
internal fun isBuzz(number: Int) = number % 5 == 0

internal fun fizzBuzzString(fizz: Boolean, buzz: Boolean, neitherNorProvider: () -> String): String {
    return when {
        fizz and buzz -> "FizzBuzz"
        fizz -> "Fizz"
        buzz -> "Buzz"
        else -> neitherNorProvider()
    }
}
