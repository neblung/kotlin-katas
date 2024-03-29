package kata.fizzbuzz

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class FizzBuzzTests {
    @Test
    fun `get started`() {
        fizzbuzz(1) shouldBe "1"
    }
}
