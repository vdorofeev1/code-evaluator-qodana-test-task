package org.example.app.commands

import org.example.app.tools.CommandRegister

class HelpCommand(private val register: CommandRegister): Command() {
    override fun execute(args: List<String>) {
        register.getCommands().forEach { if (it !is HelpCommand && it !is ExitCommand) it.help() }
    }

    override fun help() {
        println("help: prints list of commands")
    }
}