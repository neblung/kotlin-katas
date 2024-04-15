package kata.balancedparens

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BalancedParenthesesTests {
    @Test
    fun `get started`() {
        "()".shouldBeBalanced()
    }
}

private fun String.shouldBeBalanced() {
    Balance.check(this) shouldBe Balanced
}
