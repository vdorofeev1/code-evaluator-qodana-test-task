package org.example.app.tools

class InputParser {
    fun getInput(): List<String>? {
        return readlnOrNull()?.split(" ")
    }
}