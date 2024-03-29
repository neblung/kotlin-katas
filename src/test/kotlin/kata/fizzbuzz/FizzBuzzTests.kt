package kata.fizzbuzz

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FizzBuzzTests {
    @Test
    fun `neither dividable by three nor by five -- should be neither fizz nor buzz`() {
        listOf(1, 2, 16).forEach { number ->
            isFizz(number) shouldBe false
            isBuzz(number) shouldBe false
        }
    }

    @Test
    fun `dividable by three -- should be Fizz`() {
        isFizz(3) shouldBe true
        isFizz(6) shouldBe true
    }

    @Test
    fun `dividable by five -- should be Buzz`() {
        isBuzz(5) shouldBe true
        isBuzz(10) shouldBe true
    }

    @Test
    fun `dividable by three and five -- should be Fizz and Buzz`() {
        listOf(15, 75).forEach { number ->
            isFizz(number) shouldBe true
            isBuzz(number) shouldBe true
        }
    }

    @Test
    @Disabled("needs refactoring")
    fun `fizz buzz plus`() {
        fizzbuzz(13) shouldBe "Fizz"
        fizzbuzz(31) shouldBe "Fizz"

        fizzbuzz(52) shouldBe "Buzz"

        fizzbuzz(35) shouldBe "FizzBuzz"
        fizzbuzz(53) shouldBe "FizzBuzz"
    }

    @Test
    fun `test string generation`() {
        fizzBuzzString(fizz = true, buzz = true) { error("not needed") } shouldBe "FizzBuzz"
        fizzBuzzString(fizz = true, buzz = false) { error("not needed") } shouldBe "Fizz"
        fizzBuzzString(fizz = false, buzz = true) { error("not needed") } shouldBe "Buzz"
        fizzBuzzString(fizz = false, buzz = false) { "neither nor" } shouldBe "neither nor"
    }
}
