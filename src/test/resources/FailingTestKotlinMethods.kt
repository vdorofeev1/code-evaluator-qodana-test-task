class FailingTestKotlinMethods {
    fun methodOne(num: Int) {
        when {
            num > 0 -> println("Number is positive}")
            num < 0 -> println("Number is negative } } }")
            else -> println("Number is zer{o")
        }
    }

    fun methodTwo(array: IntArray): Int {
        var sum = 0
        for (num in array) {
            sum += num
        }
        return sum
    }

    fun method3() {
        var i = 0
        while (i < 5) {
            println("fun")
            i++
        }
    }

    fun method4(array: Array<String>): String {
        val result = StringBuilder()
        for (str in array) {
            if (str.length > 3) {
                result.append(str).append(", ")
            }
        }
        return result.toString()
    }
}