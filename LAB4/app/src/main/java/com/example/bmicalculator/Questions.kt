package com.example.bmicalculator

class Questions {
    var mQuestions = arrayOf(
            "COVID-19 atakuje:",
            "Jaki minimalny dystans należy zachować od innych osób?",
            "Jakie części ciała należy zasłaniać?",
            "Co należy zakładać na nos i usta?",
            "Ile powinno trwać mycie rąk wg GIS?",
            "U ilu procent chorych na COVID-19 występuje objaw suchego kaszlu?")

    private val mChoices = arrayOf(
            arrayOf("Płuca", "Brzuch", "Ręce", "Nogi"),
            arrayOf("1m", "2,5m", "5m", "100m"),
            arrayOf("Nos i usta", "Nogi", "Dłonie", "Szyję"),
            arrayOf("Majtki", "Chustę", "Maseczkę", "Szalik"),
            arrayOf("5min", "1min", "0,5min", "20s"),
            arrayOf("80", "60", "20", "40"))

    private val mCorrectAnswers = arrayOf("Płuca", "2,5m", "Nos i usta", "Maseczkę", "0,5min", "40")

    fun getQuestions(a: Int) = mQuestions?.get(a)
    fun getChoice1(a: Int) = mChoices.get(a).get(0)
    fun getChoice2(a: Int) = mChoices.get(a).get(1)
    fun getChoice3(a: Int) = mChoices.get(a).get(2)
    fun getChoice4(a: Int) = mChoices.get(a).get(3)
    fun getCorrectAnswer(a: Int) = mCorrectAnswers.get(a)
}