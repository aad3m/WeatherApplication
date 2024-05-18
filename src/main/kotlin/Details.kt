// Allows for printing the details within a single line
import org.json.JSONObject
import java.util.*

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

// Get User's Location
fun getUserCountry(): String {
    val country = Locale.getDefault().country
    if (country == "US" || country == "LR") {
        return "F"
    }
    else if (country == "BZ" || country == "BM") {
        print("Fahrenheit or Celsius? (F/C): ")
        var degreeSign = readln()
        degreeSign = formatUserInput(degreeSign)
        validatingDegree(degreeSign)
        return degreeSign
    }
    else{
        return "C"
    }
}

    // Weather Info Function
    fun printWeatherInfo(temp: Double, feelsLike: Double, tempMin: Double, tempMax: Double, humidity: Int, degreeSymbol: String,cityName: String, weather: JSONObject) {

        println(
            "Weather in $cityName"
        )
        val conditions = getCurrentConditions(weather)
        val countryCode = getUserCountry()

        println("Current Conditions: $conditions")

        val formattedTemp = String.format("%.0f", convertTemp(temp, countryCode))
        val formattedFeelsLike = String.format("%.0f", convertTemp(feelsLike, countryCode))
        val formattedTempMin = String.format("%.0f", convertTemp(tempMin, countryCode))
        val formattedTempMax = String.format("%.0f", convertTemp(tempMax, countryCode))
        println(
            "Current Temperature: $formattedTemp$degreeSymbol$countryCode"
        )
        println(
            "Feels Like: $formattedFeelsLike$degreeSymbol$countryCode"
        )
        println(
            "Today's Low & High: $formattedTempMin$degreeSymbol$countryCode / $formattedTempMax$degreeSymbol$countryCode"
        )
        println("Humidity: $humidity%")
    }

