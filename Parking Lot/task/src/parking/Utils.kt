package parking

class Utils {
    companion object {
        fun readUserInput() = readLine()?.let {
            it.split(" ")
        } ?: "-1" as List<String>
    }
}