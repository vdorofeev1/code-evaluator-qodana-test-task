package org.example.app.components

import org.example.app.components.parser.MyParser
import org.example.app.components.parser.Parser
import org.example.app.components.parser.method.Method
import java.io.File

class StyleChecker {
    companion object {
        private val parser: Parser = MyParser()
        private val STYLE_PATTERN = Regex("^[a-z][A-Za-z]*$")

        fun check(path: String): String {
            val methods = parser.getMethods(File(path))
            val answer = calculatePercentage(methods)
            return "Percentage of methods in camelCase: $answer"
        }

        internal fun isCamelCase(name: String): Boolean {
            return STYLE_PATTERN.matches(name)
        }

        private fun calculatePercentage(methods: List<Method>): Double {
            val trueCount = methods.map { isCamelCase(it.getName()) }.count { it }
            return (trueCount.toDouble() / methods.size.toDouble()) * 100
        }
    }
}