package app.components.parser

import org.example.app.components.parser.MyParser
import org.example.app.components.parser.method.JavaMethod
import org.example.app.components.parser.method.KotlinMethod
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import java.io.File

class MyParserTest {
    private val javaPath = "src/test/resources/TestJavaMethods.java"
    private val kotlinPath = "src/test/resources/TestKotlinMethods.kt"
    private val parser = MyParser()

    @Test
    fun getMethodsTest() {
        val javaMethods = parser.getMethods(File(javaPath))
        assertTrue(javaMethods.all { it is JavaMethod })

        val kotlinMethods = parser.getMethods(File(kotlinPath))
        assertTrue(kotlinMethods.any { it is KotlinMethod })
    }

    @Test
    fun getKotlinMethodsTest() {
        val methods = MyParser.getKotlinMethods(File(kotlinPath))
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
        val results = lines.map { MyParser.isKotlinMethod(it) }
        assertTrue(results.all { it == true })
    }

    @Test
    fun getJavaMethodsTest() {
        val methods = MyParser.getJavaMethods(File(javaPath))
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
        val results = lines.map { MyParser.isJavaMethod(it) }
        assertTrue(results.all { it == true })
    }

}