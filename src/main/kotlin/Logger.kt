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
    with(logger) {
       log("log 1")
       log("log 2")
       log("log 3")
    }
}