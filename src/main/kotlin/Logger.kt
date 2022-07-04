class Logger(val name: String) {
    fun log(s: String) = println("$name: $s")
}

class NotificationSender(val name: String) {
    fun send(s: String) = println("Notify: $s")
}

interface StorageContext {
    val logger: Logger
    val notificationSender: NotificationSender
}

context (StorageContext)
fun store(s: String) {
    logger.log("Stored $s on disk (from ${logger.name})")
    notificationSender.send("Successful storage event")
}

fun main() {
    val logger = Logger("main")
    val notificationSender = NotificationSender("main")
    val storageContext = object : StorageContext {
        override val logger: Logger
            get() = logger
        override val notificationSender: NotificationSender
            get() = notificationSender
    }

    with(storageContext) {
        store("an image")
        store("a text file")
        store("a cheese burger")
    }

}