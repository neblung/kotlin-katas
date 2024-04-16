package kata.balancedparens

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
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

    @Test
    fun `closing bracket that's not open -- should be reported`() {
        Balance.check("())") shouldBe Unbalanced(2, "not open")
    }

    @Test
    @Disabled("todo refactor")
    fun `closing the wrong bracket -- should be reported`() {
        Balance.check("(]") shouldBe Unbalanced(1, "not open")
    }
}

private fun String.shouldBeBalanced() {
    Balance.check(this) shouldBe Balanced
}
