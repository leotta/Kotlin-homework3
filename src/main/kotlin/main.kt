fun main (){

    //Задача 1

    var sec = 79200
    var min = sec/60
    var hours = sec/60/60
    var timeMinuts = declinationMinuts(min)
    var timeHours = declinationHours(hours)
    agoToText(sec, timeMinuts, timeHours, min, hours)

    // Задача 2

    val kopecks = 100
    var sumTransfer = 1000 * kopecks
    var sumTransferMonth = 0 * kopecks
    var cardType = "VK Pay"
    commissionAmount(cardType, sumTransferMonth, sumTransfer)
}

fun agoToText (sec: Int, timeMinuts: String, timeHours: String, min: Int, hours: Int) {
    var userstatus = when {
        sec > 0 && sec <= 60 -> "только что"
        sec >= 61 && sec <= 60*60 -> "$min $timeMinuts назад"
        sec >= 60*60+1 && sec <= 24*60*60 -> "$hours $timeHours назад"
        sec >= (24*60*60)+1 && sec <= 2 * (24*60*60) -> "сегодня"
        sec >= 2 * (24*60*60)+1 && sec <= 3 * (24*60*60) -> "вчера"
        else -> "был(а) давно"
    }
    println("Был(а) в сети $userstatus")
}

fun declinationMinuts (min: Int): String {
    val minString = when {
        min % 10 == 1 -> "минуту"
        min % 10 == 2 || min % 10 == 3 || min % 10 == 4 -> "минуты"
        else -> "минут"
    }
    return minString
}

fun declinationHours (hours: Int): String {
    val hoursString = when {
        hours % 10 == 1 -> "час"
        hours % 100 == 2 || hours % 100 == 3 || hours % 1000 != 4 || hours % 1000 != 2 || hours % 1000 != 3 || hours % 1000 != 4-> "часа"
        else -> "часов"
    }
    return hoursString
}

fun commissionAmount (cardType: String, sumTransferMonth: Int, sumTransfer: Int){
    var amount1 = sumTransfer * 0.6 / 100 + 2000
    var amount2 = sumTransfer * 0.75 / 100

    var amount = when (cardType) {
        //"VK Pay" -> 0
        cardType == "Master Card" || "Maestro" && sumTransferMonth < 7500000 -> 0
        "Visa", "Мир" -> amount1
        else -> 0

//        cardType == "VK Pay"
//        sumTransferMonth < 75000 -> 0
//        sumTransferMonth > 75000 -> sumTransfer * 0,6 / 100 + 2000
    }
    println("Ваша комиссия составляет: " + amount + " копеек")
}