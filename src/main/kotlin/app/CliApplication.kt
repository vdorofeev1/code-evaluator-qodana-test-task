package org.example.app

import org.example.app.commands.ComplexityEvaluateCommand
import org.example.app.commands.ExitCommand
import org.example.app.commands.HelpCommand
import org.example.app.commands.StyleCheckCommand
import org.example.app.tools.CommandExecutor
import org.example.app.tools.CommandRegister
import org.example.app.tools.InputParser

class CliApplication {
    private val register = CommandRegister()
    private val inputParser = InputParser()
    private val isWorking = true
    private val executor: CommandExecutor

    init {
        register.add("help", HelpCommand(register))
        register.add("evaluate", ComplexityEvaluateCommand())
        register.add("check", StyleCheckCommand())
        register.add("exit", ExitCommand())
        executor = CommandExecutor(register)
    }

    fun run() {
        while(isWorking) {
            val input = inputParser.getInput()?: return
            executor.execute(input)
        }
    }
}