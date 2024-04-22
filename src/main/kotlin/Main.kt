package org.example


fun isKotlinMethodDeclaration(line: String): Boolean {
    // Regular expression pattern to match Kotlin method declaration
    val pattern = Regex("\\s*(inline|noinline|crossinline)?\\s*(suspend)?\\s*(private|protected|internal|public)?\\s*(?:operator\\s+)?fun\\s+[a-zA-Z0-9_]+\\s*\\([^)]*\\)\\s*:?\\s*[a-zA-Z0-9_\\[\\]<>,.?\\s]*\\s*\\{?\\s*")
    return pattern.matches(line.trim())
}

fun main() {
    // Test cases
    val lines = listOf(
        "fun methodName() {",
        "suspend fun methodName(param: Int): String {",
        "private inline fun methodName(a: Int, b: Int): Int {",
        "internal fun methodName(): Unit {",
        "protected fun methodName(): String = \"Hello\"",
        "fun List<String>.methodName(): List<String> {",
        "operator fun Int.methodName(other: Int): Int {",
        "fun <T> methodName(item: T): T {"
    )

    for (line in lines) {
        println("$line -> ${isKotlinMethodDeclaration(line)}")
    }
}