package app.components

import org.example.app.components.ComplexityEvaluator
import org.example.app.components.parser.Parser
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class ComplexityEvaluatorTest {

    @Test
    fun evaluateTest() {
        val path = "src/test/resources"

        val answer = ComplexityEvaluator.evaluate(path)
        println(answer)

    }
}