package org.example.app.tools

class CommandExecutor(private val register: CommandRegister) {
    fun execute(args: List<String>) {
        val commandName = args[0]
        val command = register.getCommand(commandName)
        command.execute(args.subList(1, args.size))
    }

}