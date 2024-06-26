package org.example.app.components.parser

import org.example.app.components.parser.method.JavaMethod
import org.example.app.components.parser.method.KotlinMethod
import org.example.app.components.parser.method.Method
import java.io.File

class MyParser: ParserInterface {

    private val KOTLIN_FUNCTION_KEYWORD = "fun"
    private val JAVA_METHOD_PATTERN =
        Regex("\\s*(public|protected|private)?\\s*(abstract)?\\s*(static)?\\s*(final)?\\s*[a-zA-Z0-9<>?,.\\[\\]]+\\s+[a-zA-Z0-9_]+\\s*\\([^)]*\\)\\s*(throws\\s+[a-zA-Z0-9_.]+(,\\s*[a-zA-Z0-9_.]+)*)?\\s*(\\{|;)\\s*")
    private val JAVA_EXTENSION = "java"
    private val KOTLIN_EXTENSION = "kt"

    override fun getMethods(file: File): List<Method> {
        return when (file.extension) {
            JAVA_EXTENSION -> getJavaMethods(file)
            KOTLIN_EXTENSION -> getKotlinMethods(file)
            else -> listOf()
        }
    }

    override fun getKotlinMethods(file: File): List<KotlinMethod> {
        val methods = ArrayList<KotlinMethod>()
        val reader = file.bufferedReader()
        val iterator = reader.lineSequence().iterator()
        while (iterator.hasNext()) {
            val line = iterator.next()
            if (isKotlinMethod(line)) {
                val signature: String = line
                val method = KotlinMethod(signature, iterator, file.name)
                methods.add(method)
            }
        }
        return methods
    }

    override fun getJavaMethods(file: File): List<JavaMethod> {
        val methods = ArrayList<JavaMethod>()
        val reader = file.bufferedReader()
        val iterator = reader.lineSequence().iterator()
        while (iterator.hasNext()) {
            val line = iterator.next()
            if (isJavaMethod(line)) {
                val signature: String = line
                val method = JavaMethod(signature, iterator, file.name)
                methods.add(method)
            }
        }
        return methods
    }

    internal fun isKotlinMethod(line: String): Boolean {
        return line.split(" ").contains(KOTLIN_FUNCTION_KEYWORD)
    }

    internal fun isJavaMethod(line: String): Boolean {
        return JAVA_METHOD_PATTERN.matches(line.trim())
    }


}
