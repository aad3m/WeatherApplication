// Conversions for the different temps

fun kelvinToFahrenheit(temp: Double): Double {
    val ktof = 1.8*(temp-273)+32
    return ktof
}
fun kelvinToCelsius(temp: Double): Double {
    val ktoc = temp - 273.15
    return ktoc
}
