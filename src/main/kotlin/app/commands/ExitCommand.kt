package org.example.app.commands

import kotlin.system.exitProcess

class ExitCommand: Command() {
    override fun execute(args: List<String>) {
        exitProcess(0)
    }

    override fun help() {
        println("exit: exits from program")
    }
}