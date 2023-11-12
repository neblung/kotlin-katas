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

    @Test
    fun `multiples of ten`() {
        roman(10) shouldBe "X"
        roman(20) shouldBe "XX"
        roman(30) shouldBe "XXX"
        roman(40) shouldBe "XL"
        roman(50) shouldBe "L"
        roman(60) shouldBe "LX"
        roman(70) shouldBe "LXX"
        roman(80) shouldBe "LXXX"
        roman(90) shouldBe "XC"
    }

    @Test
    fun `below 100 -- should append two converted decimal digits`() {
        roman(11) shouldBe "XI"
        roman(49) shouldBe "XLIX"
    }
}
