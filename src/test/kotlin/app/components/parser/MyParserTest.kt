package app.components.parser

import org.example.app.components.parser.MyParser
import org.example.app.components.parser.method.JavaMethod
import org.example.app.components.parser.method.KotlinMethod
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import java.io.File

class MyParserTest {
    private val javaPath = "src/test/resources/passed/TestJavaMethods.java"
    private val kotlinPath = "src/test/resources/passed/TestKotlinMethods.kt"

    private val failedJavaPath = "src/test/resources/failed/FailingTestJavaMethods.java"
    private val failedKotlinPath = "src/test/resources/failed/FailingTestKotlinMethods.kt"

    private val parser = MyParser()

    @Test
    fun getMethodsTest() {
        val javaMethods = parser.getMethods(File(javaPath))
        javaMethods.forEach { println(it.toString()) }
        assertTrue(javaMethods.all { it is JavaMethod })

        val kotlinMethods = parser.getMethods(File(kotlinPath))
        assertTrue(kotlinMethods.any { it is KotlinMethod })
    }

    @Test
    fun getKotlinMethodsTest() {
        var methods = parser.getKotlinMethods(File(failedKotlinPath))
        assertEquals(4, methods.size)

        methods = parser.getKotlinMethods(File(kotlinPath))
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
        val results = lines.map { parser.isKotlinMethod(it) }
        assertTrue(results.all { it == true })
    }

    @Test
    fun getJavaMethodsTest() {
        var methods = parser.getJavaMethods(File(failedJavaPath))
        assertEquals(4, methods.size)

        methods = parser.getJavaMethods(File(javaPath))
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
        val results = lines.map { parser.isJavaMethod(it) }
        assertTrue(results.all { it == true })
    }

}