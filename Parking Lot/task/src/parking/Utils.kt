package parking

class Utils {
    companion object {
        fun readUserInput() = readLine()!!.split(" ").map { it.toString() }
    }
}