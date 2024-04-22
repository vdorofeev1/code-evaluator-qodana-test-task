package org.example.app.components.parser.method

class JavaMethod(override val signature: String,
                 override val iterator: Iterator<String>):
    Method(signature, iterator) {

    private val regex = Regex("((?:public|private|protected|static|final|\\s)*)\\s+(?:(abstract)\\s+)?([a-zA-Z0-9<>]+)\\s+([a-zA-Z0-9_]+)\\s*\\(([^)]*)\\)\\s*(?:throws\\s+([a-zA-Z0-9.,\\s]+))?\\s*;?\n")
    init {
        name = extractName()
        createMethod()
    }

    override fun extractName(): String {
        val result = regex.find(signature)
        return result?.groupValues?.get(1) ?: error("Method name not found in line $signature")
    }

    override fun createMethod() {
        if (!signature.contains(";")) {
            bracketsCount++
            while (iterator.hasNext() && bracketsCount != 0) {
                val line = iterator.next()
                calculateBrackets(line)
                incrementComplexityScore(line)
            }
        }
        // if abstract method
        else {
            iterator.next()
        }
    }
}