package org.example.app.components.parser.method

class JavaMethod(override val signature: String,
                 override val iterator: Iterator<String>):
    Method(signature, iterator) {

    val regex = Regex("\\s*(?:public|protected|private)?\\s*(?:static)?\\s*(?:final|abstract)?\\s*[a-zA-Z0-9<>?,.\\[\\]]+\\s+([a-zA-Z0-9_]+)\\s*\\([^)]*\\)\\s*(?:throws\\s+[a-zA-Z0-9_.]+(?:\\s*,\\s*[a-zA-Z0-9_.]+)*)?\\s*(?:\\{|;)\\s*")
    init {
        name = extractName()
        createMethod()
    }

    override fun extractName(): String {
        val result = regex.find(signature)
        return result?.groupValues?.get(1)!!
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