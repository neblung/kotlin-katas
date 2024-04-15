package kata.balancedparens

object Balance {
    fun check(toCheck: String): BalanceCheck {
        return Balanced
    }
}

sealed class BalanceCheck

data object Balanced : BalanceCheck()
