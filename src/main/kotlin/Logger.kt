class Logger(val name: String) {
    fun log(s: String) = println("$name: $s")
}

class NotificationSender(val name: String){
    fun send(s: String) = println("Notify: $s")
}

context (Logger, NotificationSender)
fun store(s: String){
    log("Stored $s on disk (from ${this@Logger.name})")
    send("Successful storage event")
}

fun main() {
    val logger = Logger("main")
    val notificationSender = NotificationSender("main")
    with(logger) {
        with(notificationSender) {
            store("an image")
            store("a text file")
            store("a cheese burger")
        }
    }
}