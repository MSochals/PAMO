package com.example.bmicalculator;

public class Questions {

    public String mQuestions[] = {
            "COVID-19 atakuje:",
            "Jaki minimalny dystans należy zachować od innych osób?",
            "Jakie części ciała należy zasłaniać?",
            "Co należy zakładać na nos i usta?",
            "Ile powinno trwać mycie rąk wg GIS?",
            "U ilu procent chorych na COVID-19 występuje objaw suchego kaszlu?",
    };

    private String mChoices[][] = {
            {"Płuca", "Brzuch", "Ręce", "Nogi"},
            {"1m", "2,5m", "5m", "100m"},
            {"Nos i usta", "Nogi", "Dłonie", "Szyję"},
            {"Majtki", "Chustę", "Maseczkę", "Szalik"},
            {"5min", "1min", "0,5min", "20s"},
            {"80", "60", "20", "40"},
    };

    private String mCorrectAnswers[] = {"Płuca", "2,5m", "Nos i usta", "Maseczkę", "0,5min", "40"};

    public String getQuestions (int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1 (int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2 (int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3 (int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4 (int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
