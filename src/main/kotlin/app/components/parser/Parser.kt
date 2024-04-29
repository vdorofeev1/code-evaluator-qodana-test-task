package org.example.app.components.parser

import org.example.app.components.parser.method.Method
import java.io.File

interface Parser {
    fun getMethods(file: File): List<Method>
}