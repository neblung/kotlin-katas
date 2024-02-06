package kata.numberToLcd

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class NumberToLcdTests {
    // method under test
    private fun Int.toLcd() = NumberToLcd.convert(this).joinToString("\n")

    @Test
    fun `get started`() {
        0.toLcd() shouldBe """
             _ 
            | |
            |_|
        """.trimIndent()
    }
}
