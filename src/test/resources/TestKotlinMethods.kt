class TestKotlinMethods {
    fun camelCase(): Int = if (true) 0 else -1

    fun NotCamelCase() {
        if (true) {
            {
                {

                }
            }
        }
        while (true) {
        }
        for (i in listOf(1)) {
        }

    }
    fun NotCase() {
        if (true) {
        }
        while (true) {
        }
    }
    fun camelCaseCaseCase() {
        if (true) {
        }
    }

    fun test4() {
        return
    }
}