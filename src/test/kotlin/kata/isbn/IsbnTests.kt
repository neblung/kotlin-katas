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

    @Nested
    inner class Isbn10 {
        @Test
        fun `positive sample -- should be isbn10`() {
            "0471958697".isIsbn10() shouldBe true
            "04-7-1958 697".isIsbn10() shouldBe true
        }

        @Test
        fun `malformed strings -- should not be isbn10`() {
            "123".isIsbn10() shouldBe false // too short
            "12345678901".isIsbn10() shouldBe false // too long
            "1X3456789X".isIsbn10() shouldBe false // bad char
            "123456789Y".isIsbn10() shouldBe false // bad char
        }

        @Test
        fun `should be isbn10 -- iff check digit correct`() {
            val validSamples = listOf(
                "0471958697",
                "0 471 60695 2",
                "0-470-84525-2",
                "0-321-14653-0",
                "0-9752298-0-X",    // which we found in the internet
            )

            // for known samples check that last digit is the only valid check-digit
            validSamples.forEach { sample ->
                val prefix = sample.dropLast(1)
                val checkDigit = sample.last()

                (('0'..'9') + 'X').forEach { c ->
                    withClue(sample to c) {
                        (prefix + c).isIsbn10() shouldBe (c == checkDigit)
                    }
                }
            }
        }
    }
}
