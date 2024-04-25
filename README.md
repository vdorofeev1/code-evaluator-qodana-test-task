## Code Quality Evaluator
This application evaluates basic aspects of code quality within a small codebase by analyzing Java or Kotlin files for complexity and performing a simple code style check.

### How to run it?
1. Clone this repository
2. Run by this command or open in IDE and run ```Main.kt```  
```
mvn clean package
java -jar target/app.jar
 ```

### Commands
#### 1. help 
Prints all commands and their description
#### 2. evaluate path/to/dir
Evaluates all methods from given directory and prints 3 methods with biggest **complexity score** (`if for while switch when` count)
#### 3. check path/to/file
Checks all methods from given file and prints percentage of methods in **camelCase**

### Decisions
This task requires code parsing, I made a decision to write my own `Parser`, which core object is `Method`, that takes 2 parameters:
1. `signature: String` - a line of file (code), that is verified as Java or Kotlin method declaration.
2. `iterator: Iterator<String>` - created from reading the file, just lines of code

Method takes these 2 arguments and once created, extracts method's name from `signature` and starts to iterate through given lines, counting **complexity score** and **brackets**. Once **brackets** count is 0, `Method` is ready and `iterator` points to the next line of code.  
Also it is very important to mention, that my own `Parser` doesn't cover all corner and default **cases** of writing code.  
To see failing tests, you can go to `ParserTest.kt` and change this variables:  
```kotlin
private val javaPath = "src/test/resources/FailingTestJavaMethods.java"
private val kotlinPath = "src/test/resources/FailingTestKotlinMethods.kt"
```

Also this app is designed as utility for code evaluating, so it is handy to add new commands, using abstract class `Command`.




