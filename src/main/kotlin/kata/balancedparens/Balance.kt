package kata.balancedparens

private val brackets = mapOf('(' to ')', '{' to '}', '[' to ']')
private val reverse = brackets.entries.associate { it.value to it.key }

object Balance {
    fun check(toCheck: String): BalanceCheck {
        val pending = mutableListOf<IndexedChar>()
        toCheck.forEachIndexed { index, c ->
            when (c) {
                in brackets.keys -> pending += index to c
                in reverse.keys -> pending.removeLastOrNull() ?: return Unbalanced(index, "not open")
            }
        }
        if (pending.isNotEmpty()) {
            val (index, c) = pending.last()
            return Unbalanced(toCheck.length, "'$c' at $index not closed")
        }
        return Balanced
    }
}

private typealias IndexedChar = Pair<Int, Char>

sealed class BalanceCheck

data object Balanced : BalanceCheck()

data class Unbalanced(val position: Int, val message: String) : BalanceCheck()
