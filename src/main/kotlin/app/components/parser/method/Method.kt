package org.example.app.components.parser.method


abstract class Method {


    private val conditionalStatements = listOf("if", "for", "while", "switch", "when")
    internal var fileName: String = ""
    internal var name: String = ""
    internal var signature: String = ""
    internal var iterator: Iterator<String> = emptyList<String>().iterator()
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
        var quotesCount = 0
        for (char in line) {
            when (char) {
                '{' -> if (quotesCount % 2 == 0) bracketsCount++
                '}' -> if (quotesCount % 2 == 0) bracketsCount--
                '"' -> quotesCount++
            }
        }
    }

    fun getName() = name

    fun getComplexityScore() = complexityScore

    override fun toString(): String {
        return "$name, file: $fileName, score: $complexityScore"
    }
}