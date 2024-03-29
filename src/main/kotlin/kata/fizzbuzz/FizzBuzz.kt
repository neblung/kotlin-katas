package kata.fizzbuzz

fun fizzbuzz(number: Int): String = when {
    number.isRelatedTo(3) and number.isRelatedTo(5) -> "FizzBuzz"
    number.isRelatedTo(3) -> "Fizz"
    number.isRelatedTo(5) -> "Buzz"
    else -> number.toString()
}

fun Int.isRelatedTo(candidate: Int) = this % candidate == 0
