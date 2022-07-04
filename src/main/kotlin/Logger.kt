class Logger(private val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

class Api {
    fun get(): String = "Hello, World"
}

fun main() {
    val logger = Logger("main")
    val api = Api()
    with(logger) {
        with(api) {
            log(get())
        }
    }
}