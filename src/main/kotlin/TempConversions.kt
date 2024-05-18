// Conversions for the different temps

// Kelvin to Fahrenheit
fun kelvinToFahrenheit(temp: Double): Double {
    val ktof = 1.8*(temp-273)+32
    return ktof
}
// Kelvin to Celsius
fun kelvinToCelsius(temp: Double): Double {
    val ktoc = temp - 273.15
    return ktoc
}
// Convert Temp Function
fun convertTemp(temp: Double, userInput: String?): Any {

    return if (userInput.equals("C")) kelvinToCelsius(temp)
    else if (userInput.equals("F") || userInput.equals("Fahrenheit")) kelvinToFahrenheit(temp)
    else println("")
}