package parking
class Utils {
    companion object {
        fun readUserInput(): List<String> {
            return readLine()?.let {
                it.split(" ")
            } ?: "-1" as List<String>
        }
    }
}