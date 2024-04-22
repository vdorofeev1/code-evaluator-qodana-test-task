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
        methods.forEach { println(it.getComplexityScore()) }
        assertEquals(methods.size, 5)
    }

    @Test
    fun isKotlinMethodTest() {
    }

    @Test
    fun getJavaMethodsTest() {
        val methods = Parser.getJavaMethods(File(javaPath))
        methods.forEach { println(it.getComplexityScore()) }
        assertEquals(5, methods.size)
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
        println(results)
        assertTrue(results.all { it == true })
    }
}