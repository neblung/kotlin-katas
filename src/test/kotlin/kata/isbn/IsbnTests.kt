package kata.isbn

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
    }
}
