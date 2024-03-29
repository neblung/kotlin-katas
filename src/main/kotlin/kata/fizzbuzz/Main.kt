package kata.fizzbuzz

/**
 * see https://cyber-dojo.org/
 */
fun main() {
    (1..100).forEach {
        println(fizzbuzz(it + 1))
    }
}
