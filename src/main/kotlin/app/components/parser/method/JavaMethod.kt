package org.example.app.components.parser.method

class JavaMethod():
    Method() {

    private val regex = Regex("\\s*(?:public|protected|private)?\\s*(?:static)?\\s*(?:final|abstract)?\\s*[a-zA-Z0-9<>?,.\\[\\]]+\\s+([a-zA-Z0-9_]+)\\s*\\([^)]*\\)\\s*(?:throws\\s+[a-zA-Z0-9_.]+(?:\\s*,\\s*[a-zA-Z0-9_.]+)*)?\\s*(?:\\{|;)\\s*")

    constructor(signature: String,
                iterator: Iterator<String>, fileName: String) : this() {
        this.signature = signature
        this.iterator = iterator
        this.fileName = fileName
        this.name = extractName()
        createMethod()
    }

    constructor(name: String, complexityScore: Int, fileName: String) : this() {
        this.name = name
        this.complexityScore = complexityScore
        this.fileName = fileName
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