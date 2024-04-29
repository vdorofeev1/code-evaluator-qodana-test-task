package org.example.app.components

import org.example.app.components.parser.MyParser
import org.example.app.components.parser.Parser
import org.example.app.components.parser.method.Method
import org.example.app.components.tools.PathHandler

class ComplexityEvaluator {

    companion object {
        private val parser: Parser = MyParser()

        fun evaluate(path: String): String {
            val files = PathHandler.getFiles(path)
            val allMethods = mutableListOf<Method>()
            files.forEach { allMethods.addAll(parser.getMethods(it)) }

            val topThreeMethods = allMethods.sortedByDescending { it.getComplexityScore() }.take(3)
            val answer = topThreeMethods.joinToString("\n") { it.toString() }

            return answer
        }

    }
}
