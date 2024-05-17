fun printWeatherInfoF(formattedTemp: String, formattedFeelsLike: String, formattedTempMin: String, formattedTempMax: String, humidity: Int, degreeSymbol: String) {
    println("Current Temperature: $formattedTemp$degreeSymbol F")
    println("Feels Like: $formattedFeelsLike$degreeSymbol F")
    println("Today's Low & High: $formattedTempMin$degreeSymbol F / $formattedTempMax$degreeSymbol F")
    println("Humidity: $humidity%")
}
fun printWeatherInfoC(formattedTemp: String, formattedFeelsLike: String, formattedTempMin: String, formattedTempMax: String, humidity: Int, degreeSymbol: String) {
    println("Current Temperature: $formattedTemp$degreeSymbol C")
    println("Feels Like: $formattedFeelsLike$degreeSymbol C")
    println("Today's Low & High: $formattedTempMin$degreeSymbol C / $formattedTempMax$degreeSymbol C")
    println("Humidity: $humidity%") 
}
