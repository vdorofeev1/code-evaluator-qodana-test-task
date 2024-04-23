package org.example.app.components.parser.method


abstract class Method(internal open val signature: String, internal open val iterator: Iterator<String>) {
    private val conditionalStatements = listOf("if", "for", "while", "switch", "when")
    internal var name = ""
    internal var complexityScore = 0
    internal var bracketsCount = 0

    internal abstract fun extractName(): String

    internal abstract fun createMethod()

    internal fun incrementComplexityScore(line: String) {
        val splitLine = line.split(" ")
        if (splitLine.any { token -> conditionalStatements.contains(token) })
            complexityScore++
    }

    internal fun calculateBrackets(line: String) {
        for (char in line) {
            if (char == '{') {
                bracketsCount++
            } else if (char == '}') {
                bracketsCount--
            }
        }
    }

    fun getName() = name

    fun getComplexityScore() = complexityScore

    override fun toString(): String {
        return "$name, score: $complexityScore"
    }
}