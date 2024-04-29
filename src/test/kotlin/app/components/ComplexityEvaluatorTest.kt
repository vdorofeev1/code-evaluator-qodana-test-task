package app.components

import org.example.app.components.ComplexityEvaluator
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class ComplexityEvaluatorTest {

    @Test
    fun evaluateTest() {
        val path = "src/test/resources"

        val actual = ComplexityEvaluator.evaluate(path)
        val expected = "mathodOne, score: 6\n" +
                "methodOne, score: 5\n" +
                "method4, score: 2"

        assertEquals(expected, actual)

    }
}