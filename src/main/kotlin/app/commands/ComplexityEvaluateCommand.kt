package org.example.app.commands

import org.example.app.components.ComplexityEvaluator
import org.example.app.components.tools.PathHandler

class ComplexityEvaluateCommand: Command() {
    override fun execute(args: List<String>) {
        val path = args[0]
        val answer = if (PathHandler.isDir(path)) {
            ComplexityEvaluator.evaluate(path)
        } else {
            "Provided path is not a directory!"
        }
        println(answer)
    }
}