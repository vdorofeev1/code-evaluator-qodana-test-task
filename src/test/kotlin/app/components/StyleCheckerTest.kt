package app.components

import org.example.app.components.StyleChecker
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import javax.swing.text.Style

class StyleCheckerTest {
    @Test
    fun check() {
        val path = "src/test/resources/TestKotlinMethods.kt"
        println(StyleChecker.check(path))
    }

    @Test
    fun isCamelCase() {
        val names = listOf(
            "camel",
            "camelCase",
            "CamelCase", //false
            "CAMELCASE", //false
            "camelcase",
            "Camelcase", //false
            "Case", //false
            "camel_case", //fasle
            "camelCaseCaseCase",
            "cAmEl"
            )
        names.forEach { println(StyleChecker.isCamelCase(it)) }

    }
}