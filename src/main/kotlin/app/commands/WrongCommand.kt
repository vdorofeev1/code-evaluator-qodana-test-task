package org.example.app.commands

import kotlin.system.exitProcess

class WrongCommand: Command() {
    override fun execute(args: List<String>) {
        println("wrong command!")
    }
}