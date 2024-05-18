
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