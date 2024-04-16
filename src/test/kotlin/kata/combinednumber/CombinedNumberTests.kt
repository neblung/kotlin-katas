package kata.combinednumber

import io.kotest.matchers.ints.beGreaterThan
import io.kotest.matchers.ints.beLessThan
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/*
 * It turns out that the problem reduces to write a proper comparator.
 */
class CombinedNumberTests {
    @Test
    fun `numbers should be ordered appropriately`() {
        compare(123, 124) should beLessThan(0) // because 123124 < 124123
        compare(9, 50) should beGreaterThan(0) // because 950 > 509
        compare(5, 50) should beGreaterThan(0) // because 550 > 505
        compare(5, 56) should beLessThan(0) // because 565 > 556
    }

    @Test
    fun `samples`() {
        listOf(50, 2, 1, 9).combine() shouldBe "95021"
        listOf(5, 50, 56).combine() shouldBe "56550"
        listOf(420, 42, 423).combine() shouldBe "42423420"
    }
}
