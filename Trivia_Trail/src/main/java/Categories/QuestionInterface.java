package Trivia_Trail.src.main.java.Categories;

import java.util.List;

public interface QuestionInterface {

    List<Question> questionSet();

    void addQuestionToSet(String question, String[] choices, String answer);
}
