package app.components.parser

import org.example.app.components.parser.Parser
import org.example.app.components.parser.method.JavaMethod
import org.example.app.components.parser.method.KotlinMethod
import org.example.app.components.parser.method.Method
import org.example.app.components.tools.PathHandler
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import java.io.File

class ParserTest {
    private val javaPath = "src/test/resources/TestJavaMethods.java"
    private val kotlinPath = "src/test/resources/TestKotlinMethods.kt"

    @Test
    fun getMethodsTest() {
        val javaMethods = Parser.getMethods(File(javaPath))
        assertTrue(javaMethods.all { it is JavaMethod })

        val kotlinMethods = Parser.getMethods(File(kotlinPath))
        assertTrue(kotlinMethods.any { it is KotlinMethod })
    }

    @Test
    fun getKotlinMethodsTest() {
        val methods = Parser.getKotlinMethods(File(kotlinPath))
        assertEquals(4, methods.size)
    }

    @Test
    fun isKotlinMethodTest() {
        val lines = listOf(
            "fun methodName() {",
            "fun methodName(param: Int): Int {",
            "private fun methodName(str: String, num: Int): String {",
            "fun methodName(): Unit {",
            "fun methodName(param: Int): String {",
            "protected abstract fun methodName()",
            "fun methodName(str: String): Int = 42",
            "fun fun5() {",
            "fun fun6() = Unit")
        val results = lines.map { Parser.isKotlinMethod(it) }
        assertTrue(results.all { it == true })
    }

    @Test
    fun getJavaMethodsTest() {
        val methods = Parser.getJavaMethods(File(javaPath))
        assertEquals(4, methods.size)
    }


    @Test
    fun isJavaMethodtest() {
        val lines = listOf(
            "public void methodName() {",
            "protected int methodName(int param) throws Exception {",
            "private static String methodName(String str, int num) {",
            "public static final void methodName() throws CustomException, AnotherException {",
            "void methodName() {",
            "String methodName(int param) {",
            "protected abstract void methodName();",
            "int methodName(String str) throws IOException;",
            "public static final void fun5() throws RuntimeException {"
        )
        val results = lines.map { Parser.isJavaMethod(it) }
        assertTrue(results.all { it == true })
    }

}