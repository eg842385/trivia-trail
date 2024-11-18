package Trivia_Trail.src.main.java.Categories;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public abstract class Question {
    private String question;
    private ArrayList<String> choices;
    private String answer;

    // Constructor
    public Question(String question, String[] choices, String answer) {
        this.question = question;
        this.choices = new ArrayList<>();
        for (int i = 0; i < choices.length; i++) {
            this.choices.add(choices[i]);
        }
//       make questions shuffle
        Collections.shuffle(this.choices);
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public String getAnswer() {
        return answer;
    }

    public static List<Question> questionSet() {
        return new ArrayList<>();
    }
}
