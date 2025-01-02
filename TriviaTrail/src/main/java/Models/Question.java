package TriviaTrail.src.main.java.Models;

import java.util.List;

public interface Question {
    String getQuestion();

    List<String> getChoices();

    String getAnswer();
}