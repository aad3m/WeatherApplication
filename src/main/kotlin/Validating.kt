import java.net.HttpURLConnection
import java.net.URL
import kotlin.system.exitProcess

fun validatingDegree(input: String){
    if (input == "F" || input == "C"){
        return
    }
    else{
        println("Error: Invalid degree input.")
        exitProcess(1)
    }
}

fun validatingAPIKey(input: String){
    if (input.isBlank()) {
        println("Error: No API provided.")
        println("Create One Here -> https://openweathermap.org/api ")
        exitProcess(0)
    }
    if (input.length != 32 && input.isNotBlank()){
        println("Error: Invalid API.")
        exitProcess(1)
    }
}

fun validatingCity(city: String, apiKey: String) {
    if (city.isBlank()) {
        println("Error: No city has been inputted")
        exitProcess(1)
    }

    val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    if (connection.responseCode != HttpURLConnection.HTTP_OK) {
        println("Error: Not valid city.")
        return
    }
}