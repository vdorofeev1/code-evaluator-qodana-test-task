package org.example.app.commands

abstract class Command: Executable {
    abstract override fun execute(args: List<String>)

    abstract fun help()
}