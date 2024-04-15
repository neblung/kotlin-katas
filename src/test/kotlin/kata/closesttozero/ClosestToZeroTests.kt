package kata.closesttozero

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ClosestToZeroTests {
    @Test
    fun `single item list -- should return only element`() {
        listOf(5).closestToZero() shouldBe 5
    }

    @Test
    fun `list of non-negatives -- should return its minimum`() {
        listOf(10, 5, 20).closestToZero() shouldBe 5
    }
}
