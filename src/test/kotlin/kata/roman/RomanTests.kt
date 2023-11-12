package kata.roman

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RomanTests {
    @Test
    fun `below ten`() {
        roman(1) shouldBe "I"
        roman(2) shouldBe "II"
        roman(3) shouldBe "III"
        roman(4) shouldBe "IV"
        roman(5) shouldBe "V"
        roman(6) shouldBe "VI"
        roman(7) shouldBe "VII"
        roman(8) shouldBe "VIII"
        roman(9) shouldBe "IX"
    }
}
