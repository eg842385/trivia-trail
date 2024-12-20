package Trivia_Trail.src.main.java.Categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Java extends Question implements QuestionInterface {
    private List<Question> questionSet = new ArrayList<>();

    public Java(){}

    public Java(String question, String[] choices, String answer) {
        super(question, choices, answer);
    }

    @Override
    public List<Question> questionSet() {
        questionSet.add(new Java(
                "Overriding and overloading are types of...",
                new String[]{"Polymorphism", "Inheritance", "Abstraction", "Encapsulation"},
                "Polymorphism"
        ));

        questionSet.add(new Java(
                "What is the primary method every Java application must have?",
                new String[]{"main()", "run()", "start()", "init()"},
                "main()"
        ));

        questionSet.add(new Java(
                "What is the default value of a boolean variable in Java?",
                new String[]{"true", "false", "null", "undefined"},
                "false"
        ));

        questionSet.add(new Java(
                "Which keyword is used to inherit a class in Java?",
                new String[]{"extends", "implements", "inherits", "super"},
                "extends"
        ));

        questionSet.add(new Java(
                "What is the result of the expression 9 / 2 in Java?",
                new String[]{"4.5", "4", "5", "error"},
                "4"
        ));

        questionSet.add(new Java(
                "What does the final keyword mean when applied to a variable?",
                new String[]{"the variable can be reassigned", "the variable is mutable", "the variable is private", "the variable is a constant"},
                "the variable is a constant"
        ));

        questionSet.add(new Java(
                "What is a Checked Exception in Java?",
                new String[]{"An exception that occurs due to programmer error", "An exception that must be either caught or declared in the method signature", "An exception that the JVM handles automatically", "An exception caused by hardware failure"},
                "An exception that must be either caught or declared in the method signature"
        ));

        questionSet.add(new Java(
                "What does the hashCode() method do in Java?",
                new String[]{"Returns a random integer", "Compares two objects", "Returns an integer hash code for an object", "Converts an object to a string"},
                "Returns an integer hash code for an object"
        ));

        Collections.shuffle(questionSet, new Random());

        return questionSet;
    }

    @Override
    public void addQuestionToSet(String question, String[] choices, String answer) {
        Java newQuestion = new Java(question,choices,answer);
        questionSet.add(newQuestion);
    }
}
