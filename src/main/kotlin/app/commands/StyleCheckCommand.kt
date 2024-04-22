package org.example.app.commands

import org.example.app.components.ComplexityEvaluator
import org.example.app.components.StyleChecker
import org.example.app.components.tools.PathHandler

class StyleCheckCommand: Command() {
    private val checker = StyleChecker()

    override fun execute(args: List<String>) {
        val path = args[0]
        val answer = if (PathHandler.isFile(path)) {
            StyleChecker.check(path)
        } else {
            "Provided path is not a file!"
        }
        println(answer)
    }
}