package kata.fizzbuzz

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class FizzBuzzTests {
    @Test
    fun `neither dividable by three nor by five -- should be the number itself`() {
        fizzbuzz(1) shouldBe "1"
        fizzbuzz(2) shouldBe "2"
        fizzbuzz(16) shouldBe "16"
    }

    @Test
    fun `dividable by three -- should be Fizz`() {
        fizzbuzz(3) shouldBe "Fizz"
        fizzbuzz(6) shouldBe "Fizz"
    }

    @Test
    fun `dividable by five -- should be Buzz`() {
        fizzbuzz(5) shouldBe "Buzz"
        fizzbuzz(10) shouldBe "Buzz"
    }

    @Test
    fun `dividable by three and five -- should be FizzBuzz`() {
        fizzbuzz(15) shouldBe "FizzBuzz"
        fizzbuzz(75) shouldBe "FizzBuzz"
    }
}
