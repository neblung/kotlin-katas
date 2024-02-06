package kata.numberToLcd

import io.kotest.matchers.shouldBe
import kata.numberToLcd.NumberToLcd.toDigits
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NumberToLcdTests {
    // method under test
    private fun Int.toLcd() = NumberToLcd.convert(this).joinToString("\n")

    @Test
    fun `single digits`() {
        0.toLcd() shouldBe """
             _ 
            | |
            |_|
        """.trimIndent()

        1.toLcd() shouldBe """
           >   
           >  |
           >  |
        """.trimMargin(">")

        2.toLcd() shouldBe """
             _ 
             _|
            |_ 
        """.trimIndent()

        3.toLcd() shouldBe """
           > _ 
           > _|
           > _|
        """.trimMargin(">")

        4.toLcd() shouldBe """
               
            |_|
              |
        """.trimIndent()

        5.toLcd() shouldBe """
             _ 
            |_ 
             _|
        """.trimIndent()

        6.toLcd() shouldBe """
             _ 
            |_ 
            |_|
        """.trimIndent()

        7.toLcd() shouldBe """
           > _ 
           >  |
           >  |
        """.trimMargin(">")

        8.toLcd() shouldBe """
             _ 
            |_|
            |_|
        """.trimIndent()

        9.toLcd() shouldBe """
             _ 
            |_|
             _|
        """.trimIndent()
    }

    @Test
    @Disabled("too complicated")
    fun `numbers greater than 9 -- should be composed from their digits`() {
        1968.toLcd() shouldBe """
           >    _  _  _
           >  ||_||_ |_|
           >  | _||_||_|
        """.trimMargin(">")
    }

    @Nested
    inner class TestHelperFunctions {
        @Test
        fun `to digits -- by example`() {
            1204.toDigits() shouldBe listOf(1, 2, 0, 4)
        }
    }
}
