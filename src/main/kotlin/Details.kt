// Allows for printing the details within a single line
import org.json.JSONObject

// Format Text
fun formatUserInput(userInput: String) : String{
    val formattedUserInput = userInput.uppercase()
    return formattedUserInput
}
fun formatCity(city: String) : String {
    var formattedCity = city.lowercase()
    formattedCity = formattedCity.replaceFirstChar { it.titlecase() }
    if (formattedCity.contains(" ")) {
        formattedCity = formattedCity.split(" ").joinToString("+") { it.lowercase().capitalize() }
    }
    return formattedCity
}



// Convert Temp Function
fun convertTemp(temp: Double, userInput: String?): Any {

    return if (userInput.equals("C")) kelvinToCelsius(temp)
    else if (userInput.equals("F") || userInput.equals("Fahrenheit")) kelvinToFahrenheit(temp)
    else println("")
}
// Current Conditions Function
fun getCurrentConditions(jsonResponse: JSONObject): String {
    val weatherArray = jsonResponse.getJSONArray("weather")
    if (weatherArray.length() > 0) {
        val weatherObj = weatherArray.getJSONObject(0)
        return weatherObj.getString("description")
    } else {
        return ""
    }
}

    // Weather Info Function
    fun printWeatherInfo(temp: Double, feelsLike: Double, tempMin: Double, tempMax: Double, humidity: Int, degreeSymbol: String, userInput: String, cityName: String, weather: JSONObject) {

        println(
            "Weather in $cityName"
        )
        val conditions = getCurrentConditions(weather)

        println("Current Conditions: $conditions")

        val formattedTemp = String.format("%.0f", convertTemp(temp, userInput))
        val formattedFeelsLike = String.format("%.0f", convertTemp(feelsLike, userInput))
        val formattedTempMin = String.format("%.0f", convertTemp(tempMin, userInput))
        val formattedTempMax = String.format("%.0f", convertTemp(tempMax, userInput))
        println(
            "Current Temperature: $formattedTemp$degreeSymbol$userInput"
        )
        println(
            "Feels Like: $formattedFeelsLike$degreeSymbol$userInput"
        )
        println(
            "Today's Low & High: $formattedTempMin$degreeSymbol$userInput / $formattedTempMax$degreeSymbol$userInput"
        )
        println("Humidity: $humidity%")
    }

