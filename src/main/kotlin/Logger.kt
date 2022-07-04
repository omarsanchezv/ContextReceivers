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
    logger.log("log 1")
    logger.log("log 2")
    logger.log("log 3")
}