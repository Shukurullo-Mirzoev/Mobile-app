package com.example.quizapp.data

import com.example.quizapp.R

// Bayroqlar uchun savollar

fun getFlagQuestions(region: String): List<Pair<String, List<String>>> {
    return listOf(
        "🇺🇿" to listOf("Узбекистан", "Таджикистан", "Казахстан", "Кыргызстан"),
        "🇷🇺" to listOf("Россия", "Украина", "Беларусь", "Казахстан"),
        "🇺🇸" to listOf("США", "Канада", "Мексика", "Австралия"),
        "🇩🇪" to listOf("Германия", "Франция", "Италия", "Испания"),
        "🇨🇳" to listOf("Китай", "Япония", "Южная Корея", "Вьетнам"),
        "🇯🇵" to listOf("Япония", "Китай", "Южная Корея", "Сингапур")
    ).shuffled().take(10) // Tasodifiy 10 ta savol olish
}


//fun getFlagQuestions(region: String): List<Pair<Int, String>> {
//    return when (region) {
//        "Азия" -> listOf(
//            R.drawable.tajikistan to "Таджикистан",
//            R.drawable.uzbekistan to "Узбекистан",
//            R.drawable.kyrgyzstan to "Киргизия",
//            R.drawable.kazakhstan to "Казахстан",
//            R.drawable.china to "Китай",
//            R.drawable.japan to "Япония",
//            R.drawable.south_korea to "Южная Корея",
//            R.drawable.india to "Индия",
//            R.drawable.pakistan to "Пакистан",
//            R.drawable.iran to "Иран"
//        )
//        "Европа" -> listOf(
//            R.drawable.russia to "Россия",
//            R.drawable.germany to "Германия",
//            R.drawable.france to "Франция",
//            R.drawable.italy to "Италия",
//            R.drawable.spain to "Испания",
//            R.drawable.uk to "Великобритания",
//            R.drawable.netherlands to "Нидерланды",
//            R.drawable.belgium to "Бельгия",
//            R.drawable.sweden to "Швеция",
//            R.drawable.switzerland to "Швейцария"
//        )
//        else -> emptyList()
//    }
//}

// Pul birliklari uchun savollar
fun getMoneyQuestions(region: String): List<Pair<String, List<String>>> {
    return when (region) {
        "Азия" -> listOf(
            "Сомони" to listOf("Таджикистан", "Узбекистан", "Казахстан", "Кыргызстан"),
            "Сум" to listOf("Узбекистан", "Таджикистан", "Казахстан", "Кыргызстан"),
            "Тенге" to listOf("Казахстан", "Узбекистан", "Кыргызстан", "Таджикистан"),
            "Сом" to listOf("Кыргызстан", "Казахстан", "Узбекистан", "Таджикистан"),
            "Рупия" to listOf("Индия", "Пакистан", "Непал", "Бангладеш"),
            "Йена" to listOf("Япония", "Китай", "Южная Корея", "Монголия"),
            "Юань" to listOf("Китай", "Япония", "Южная Корея", "Монголия"),
            "Вон" to listOf("Южная Корея", "Китай", "Япония", "Монголия"),
            "Риал" to listOf("Иран", "Саудовская Аравия", "ОАЭ", "Катар"),
            "Бат" to listOf("Таиланд", "Камбоджа", "Лаос", "Малайзия")
        )
        "Европа" -> listOf(
            "Евро" to listOf("Германия", "Франция", "Италия", "Испания"),
            "Фунт стерлингов" to listOf("Великобритания", "Франция", "Германия", "Испания"),
            "Франк" to listOf("Швейцария", "Франция", "Германия", "Австрия"),
            "Злотый" to listOf("Польша", "Чехия", "Германия", "Австрия"),
            "Крона" to listOf("Швеция", "Дания", "Норвегия", "Финляндия"),
            "Форинт" to listOf("Венгрия", "Чехия", "Словакия", "Австрия"),
            "Лев" to listOf("Болгария", "Румыния", "Сербия", "Греция"),
            "Куна" to listOf("Хорватия", "Словения", "Австрия", "Венгрия"),
            "Лира" to listOf("Турция", "Греция", "Италия", "Испания"),
            "Динар" to listOf("Сербия", "Хорватия", "Босния", "Черногория")
        )
        else -> emptyList()
    }
}


// Poytaxtlar uchun savollar

fun getCapitalQuestions(region: String): List<Pair<String, List<String>>> {
    return when (region) {
        "Азия" -> listOf(
            "Душанбе" to listOf("Таджикистан", "Узбекистан", "Казахстан", "Кыргызстан"),
            "Ташкент" to listOf("Узбекистан", "Туркменистан", "Таджикистан", "Казахстан"),
            "Астана" to listOf("Казахстан", "Узбекистан", "Кыргызстан", "Таджикистан"),
            "Бишкек" to listOf("Кыргызстан", "Таджикистан", "Казахстан", "Узбекистан"),
            "Кабул" to listOf("Афганистан", "Пакистан", "Иран", "Туркменистан"),
            "Дели" to listOf("Индия", "Пакистан", "Непал", "Бангладеш"),
            "Пекин" to listOf("Китай", "Япония", "Корея", "Монголия"),
            "Сеул" to listOf("Южная Корея", "Китай", "Япония", "Монголия"),
            "Токио" to listOf("Япония", "Китай", "Южная Корея", "Монголия"),
            "Бангкок" to listOf("Таиланд", "Малайзия", "Камбоджа", "Индонезия")
        )
        "Европа" -> listOf(
            "Берлин" to listOf("Германия", "Франция", "Италия", "Испания"),
            "Париж" to listOf("Франция", "Германия", "Италия", "Испания"),
            "Рим" to listOf("Италия", "Франция", "Германия", "Испания"),
            "Мадрид" to listOf("Испания", "Италия", "Франция", "Германия"),
            "Лондон" to listOf("Великобритания", "Франция", "Германия", "Испания"),
            "Амстердам" to listOf("Нидерланды", "Германия", "Бельгия", "Франция"),
            "Варшава" to listOf("Польша", "Чехия", "Германия", "Австрия"),
            "Прага" to listOf("Чехия", "Германия", "Польша", "Австрия"),
            "Будапешт" to listOf("Венгрия", "Австрия", "Чехия", "Словакия"),
            "Афины" to listOf("Греция", "Италия", "Турция", "Болгария")
        )
        else -> emptyList()
    }
}
