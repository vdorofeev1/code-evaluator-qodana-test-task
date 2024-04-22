package org.example.app.components.parser.method

class KotlinMethod(override val signature: String,
                   override val iterator: Iterator<String>):
    Method(signature, iterator) {

    private val regex = Regex("fun\\s+([a-zA-Z0-9_]+)\\s*\\(")

    init {
        name = extractName()
        createMethod()
    }

    override fun extractName(): String {
        val result = regex.find(signature)
        return result?.groupValues?.get(1) ?: error("Method name not found in line $signature")
    }

    override fun createMethod() {
        val splitSignature = signature.split(" ")
        if (splitSignature.contains("{")) {
            bracketsCount++
            while (iterator.hasNext() && bracketsCount != 0) {
                val line = iterator.next()
                calculateBrackets(line)
                incrementComplexityScore(line)
            }
        }
        //if one-line function without brackets
        else {
            incrementComplexityScore(signature)
            iterator.next()
        }
    }

}