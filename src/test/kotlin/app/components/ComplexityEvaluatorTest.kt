package app.components

import org.example.app.components.ComplexityEvaluator
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

class ComplexityEvaluatorTest {

    @Test
    fun evaluateTest() {
        val path = "src/test/resources/passed"

        val actual = ComplexityEvaluator.evaluate(path)
        val expected = "method4, file: TestKotlinMethods.kt, score: 2\n" +
                "mathodOne, file: TestJavaMethods.java, score: 2\n" +
                "METHODFOUR, file: TestJavaMethods.java, score: 2"

        assertEquals(expected, actual)

    }
}