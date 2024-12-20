package Trivia_Trail.src.main.java.Categories;

import java.util.List;

public interface QuestionInterface {

    public List<Question> questionSet();

    public void addQuestionToSet(String question, String[] choices, String answer);
}
