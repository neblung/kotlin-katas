package kata.balancedparens

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BalancedParenthesesTests {
    @Test
    fun `closing all opened brackets -- should be balanced`() {
        "()".shouldBeBalanced()
        "(())".shouldBeBalanced()
    }
}

private fun String.shouldBeBalanced() {
    Balance.check(this) shouldBe Balanced
}
