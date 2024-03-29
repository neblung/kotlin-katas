package kata.fizzbuzz

fun fizzbuzz(number: Int): String = when {
    (number % 3 == 0) -> "Fizz"
    else -> number.toString()
}
