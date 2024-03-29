package kata.fizzbuzz

fun fizzbuzz(number: Int): String {
    val relatedTo3 = number.isRelatedTo(3)
    val relatedTo5 = number.isRelatedTo(5)
    return when {
        relatedTo3 and relatedTo5 -> "FizzBuzz"
        relatedTo3 -> "Fizz"
        relatedTo5 -> "Buzz"
        else -> number.toString()
    }
}

fun Int.isRelatedTo(candidate: Int) = (this % candidate == 0) or (candidate.digitToChar() in toString())
