package org.example.app.components.parser

import com.github.javaparser.JavaParser
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.stmt.ForStmt
import com.github.javaparser.ast.stmt.IfStmt
import com.github.javaparser.ast.stmt.SwitchStmt
import com.github.javaparser.ast.stmt.WhileStmt
import org.example.app.components.parser.method.JavaMethod
import org.example.app.components.parser.method.KotlinMethod
import org.example.app.components.parser.method.Method

import java.io.File
class ThirdPartyParser: ParserInterface {

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
        TODO("Not yet implemented")
    }

    override fun getJavaMethods(file: File): List<JavaMethod> {
        val methods = ArrayList<JavaMethod>()
        val parsed = JavaParser().parse(file)
        val rootNode = parsed.result.get()
        val parsedMethods = rootNode.findAll(MethodDeclaration::class.java)
        for (method in parsedMethods) {
            methods.add(JavaMethod(method.nameAsString, getStmtCount(method), file.name))
        }
        return methods
    }

    internal fun getStmtCount(method: MethodDeclaration): Int {
        var count = 0
        count += method.findAll(IfStmt::class.java).size
        count += method.findAll(ForStmt::class.java).size
        count += method.findAll(WhileStmt::class.java).size
        count += method.findAll(SwitchStmt::class.java).size
        return count
    }
}



