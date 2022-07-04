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
    store("an image", logger)
    store("a text file", logger)
    store("a chese burger", logger)
}