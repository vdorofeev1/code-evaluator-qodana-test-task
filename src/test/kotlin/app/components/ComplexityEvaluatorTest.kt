package app.components

import org.example.app.components.ComplexityEvaluator
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class ComplexityEvaluatorTest {

    @Test
    fun evaluateTest() {
        val path = "src/test/resources"

        val actual = ComplexityEvaluator.evaluate(path)
        val expected = "method4, score: 2\n" +
                "mathodOne, score: 2\n" +
                "METHODFOUR, score: 2"

        assertEquals(expected, actual)

    }
}