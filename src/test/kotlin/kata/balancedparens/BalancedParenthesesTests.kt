package kata.balancedparens

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class BalancedParenthesesTests {
    @Test
    fun `closing all opened brackets -- should be balanced`() {
        "()".shouldBeBalanced()
        "(())".shouldBeBalanced()
    }

    @Test
    fun `not closing open bracket -- should be reported`() {
        Balance.check("(()") shouldBe Unbalanced(3, "'(' at 0 not closed")
    }
}

private fun String.shouldBeBalanced() {
    Balance.check(this) shouldBe Balanced
}
