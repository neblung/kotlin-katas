package kata.balancedparens

object Balance {
    fun check(toCheck: String): BalanceCheck {
        val pending = mutableListOf<Char>()
        for (c in toCheck) {
            when (c) {
                '(' -> pending += '('
                ')' -> pending.removeLast()
            }
        }
        return Balanced
    }
}

sealed class BalanceCheck

data object Balanced : BalanceCheck()
