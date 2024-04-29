package app.components

import org.example.app.components.StyleChecker
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import javax.swing.text.Style
import kotlin.math.exp

class StyleCheckerTest {
    @Test
    fun check() {
        val path = "src/test/resources/passed/TestKotlinMethods.kt"
        val actual = StyleChecker.check(path)
        val expected = "Percentage of methods in camelCase: 50.0"
        assertEquals(expected, actual)
    }

    @Test
    fun isCamelCase() {
        val names = listOf(
            "camel",
            "camelCase",
            "camelcase",
            "camelCaseCaseCase",
            "cAmEl"
            )
        assertTrue(names.all { StyleChecker.isCamelCase(it) } )

    }
}