package org.example.app.tools

import org.example.app.commands.Command
import org.example.app.commands.WrongCommand

class CommandRegister {
    private val commands = mutableMapOf<String, Command>()

    fun add(name: String, command: Command) {
        commands[name] = command
    }
    fun getCommand(name: String): Command {
        return commands.getOrDefault(name, WrongCommand())
    }
    fun getCommands(): Set<String> = commands.keys
}