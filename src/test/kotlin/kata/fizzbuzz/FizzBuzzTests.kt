package kata.fizzbuzz

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class FizzBuzzTests {
    @Test
    fun `neither dividable by three nor by five nor containing three or five -- should be neither fizz nor buzz`() {
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

    @Nested
    inner class FizzBuzzPlus {
        @Test
        fun `contains 3 -- should be fizz`() {
            isFizz(13) shouldBe true
            isFizz(31) shouldBe true
        }

        @Test
        fun `contains 5 -- should be buzz`() {
            isBuzz(35) shouldBe true
            isBuzz(53) shouldBe true
        }

    }

    @Test
    fun `test string generation`() {
        fizzBuzzString(fizz = true, buzz = true) { error("not needed") } shouldBe "FizzBuzz"
        fizzBuzzString(fizz = true, buzz = false) { error("not needed") } shouldBe "Fizz"
        fizzBuzzString(fizz = false, buzz = true) { error("not needed") } shouldBe "Buzz"
        fizzBuzzString(fizz = false, buzz = false) { "neither nor" } shouldBe "neither nor"
    }
}
