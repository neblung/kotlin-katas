package kata.fizzbuzz

fun fizzbuzz(number: Int): String = when {
    (number % 3 == 0) -> "Fizz"
    (number % 5 == 0) -> "Buzz"
    else -> number.toString()
}
