class Logger(private val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

fun store(s: String, logger: Logger){
    logger.log("Stored $s on disk")
}

fun main() {
    val logger = Logger("main")
    with(logger) {
        store("an image")
        store("a text file")
        store("a chese burger")
    }
}