package org.example.app.components.tools

import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Collectors

class PathHandler {
    companion object {
        fun isDir(path: String): Boolean {
            return Files.isDirectory(Paths.get(path))
        }

        fun isFile(path: String): Boolean {
            return Files.isRegularFile(Paths.get(path))
        }

        fun getFiles(path: String): List<File> {
            return Files.list(Paths.get(path))
                .map { it.toFile() }
                .filter { it.isFile }
                .collect(Collectors.toList())
        }
    }
}