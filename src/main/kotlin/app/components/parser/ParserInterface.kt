package org.example.app.components.parser

import org.example.app.components.parser.method.JavaMethod
import org.example.app.components.parser.method.KotlinMethod
import org.example.app.components.parser.method.Method
import java.io.File

interface ParserInterface {
    fun getMethods(file: File): List<Method>

    fun getKotlinMethods(file: File): List<KotlinMethod>

    fun getJavaMethods(file: File): List<JavaMethod>
}