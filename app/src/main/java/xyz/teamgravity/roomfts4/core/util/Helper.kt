package xyz.teamgravity.roomfts4.core.util

object Helper {

    /**
     * Escape FTS special characters - and "
     */
    fun sanitizeQuery(query: String): String {
        val replacedQuery = query.replace("\"", "\"\"")
        return "*\"$replacedQuery\"*"
    }
}