import org.json.JSONException
import java.net.HttpURLConnection
import java.net.URL
import java.io.IOException
import java.io.InputStreamReader
import java.io.BufferedReader
import org.json.JSONObject
import java.util.*

fun main() {
    try {
        // API Key
        println("Welcome to the Weather App")
        print("Enter your API Key: ")
        val apiKey = readln()
        validatingAPIKey(apiKey)

        // City
        print("Enter a city: ")
        var city: String = readln()
        city = formatCity(city)
        validatingCity(city,apiKey)

        // Open Connection
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"


        // Read Response
        val reader = BufferedReader(InputStreamReader(connection.inputStream))
        val response = StringBuilder()
        var line = reader.readLine()

        // Read Lines
        while (line != null) {
            response.append(line)
            line = reader.readLine()
        }
        // Close Reader
        reader.close()

        // Parse JSON Response
        val jsonResponse = JSONObject(response.toString())
        val degreeSymbol = "\u00b0"

        // Get City Name
        val cityName = jsonResponse.getString("name")
        val mainObject = jsonResponse.getJSONObject("main")
        if (mainObject != null && mainObject.has("temp")) {

            // Get Temps
            val temp = mainObject.getDouble("temp")
            val feelsLike = mainObject.getDouble("feels_like")
            val tempMin = mainObject.getDouble("temp_min")
            val tempMax = mainObject.getDouble("temp_max")
            val humidity = mainObject.getInt("humidity")

            // Display Info
            printWeatherInfo(temp, feelsLike, tempMin, tempMax, humidity,degreeSymbol,cityName,jsonResponse)
        }

        // Close Connection
        connection.disconnect()
    }
    // Exceptions
    catch (e: IOException) {
        println("Error: Could not retrieve weather data.")
        println("Error URL: ${e.message}")
        }
    catch (e: IllegalFormatException) {
        println("Error: Illegal format.")
    }
    catch (e: JSONException) {
        println("Error: Invalid response from the server.")
    }
}