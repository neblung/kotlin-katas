package kata.isbn

import io.kotest.assertions.withClue
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class IsbnTests {
    @Test
    fun `normalize -- should remove spaces and hyphens`() {
        normalize("9780471486480") shouldBe "9780471486480"
        normalize("978-0-471-48648-0") shouldBe "9780471486480"
        normalize("978 0 471 48648 0") shouldBe "9780471486480"
    }

    @Nested
    inner class Isbn13 {
        @Test
        fun `positive sample -- should be isbn13`() {
            "9780470059029".isIsbn13() shouldBe true
            "97804 7005902-9".isIsbn13() shouldBe true
        }

        @Test
        fun `too short or too long -- should not be isbn13`() {
            "12345".isIsbn13() shouldBe false
            "12345678901234".isIsbn13() shouldBe false
        }

        @Test
        fun `contains non digit -- should not be isbn13`() {
            "123456789X123".isIsbn13() shouldBe false
        }

        @Test
        fun `should be isbn13 -- iff check digit correct`() {
            val validSamples = listOf(
                "9780470059029",
                "978 0 471 48648 0",
                "978-0596809485",
                "978-0-13-149505-0",
                "978-0-262-13472-9",
            )

            // for known samples check that last digit is the only valid check-digit
            validSamples.forEach { sample ->
                val prefix = sample.dropLast(1)
                val checkDigit = sample.last()

                ('0'..'9').forEach { c ->
                    withClue(sample to c) {
                        (prefix + c).isIsbn13() shouldBe (c == checkDigit)
                    }
                }
            }
        }
    }
}
