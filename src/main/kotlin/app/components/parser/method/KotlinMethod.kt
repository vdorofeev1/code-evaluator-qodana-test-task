package org.example.app.components.parser.method

class KotlinMethod():
    Method() {

    private val regex = Regex("fun\\s+([a-zA-Z0-9_]+)\\s*\\(")

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