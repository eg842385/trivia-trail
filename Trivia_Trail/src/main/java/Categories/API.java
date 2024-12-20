package Trivia_Trail.src.main.java.Categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class API extends Question implements QuestionInterface{
    private List<Question> questionSet = new ArrayList<>();

    public API(String question, String[] choices, String answer) {
        super(question, choices, answer);
    }

    public API(){}

    @Override
    public List<Question> questionSet() {

        questionSet.add(new API(
                "What does REST stand for in RESTful APIs?",
                new String[]{"Representational State Transfer", "Reliable State Transfer", "Remote Execution Standard Transfer", "Random Encapsulation of State and Transfer"},
                "Representational State Transfer"
        ));

        questionSet.add(new API(
                "Which HTTP method is commonly used to retrieve data from a server in a RESTful API?",
                new String[]{"POST", "GET", "PUT", "DELETE"},
                "GET"
        ));

        questionSet.add(new API(
                "What is the standard HTTP status code for 'Not Found'?",
                new String[]{"200", "404", "500", "403"},
                "404"
        ));

        questionSet.add(new API(
                "Which of the following is NOT an HTTP method?",
                new String[]{"CONNECT", "HEAD", "PATCH", "FETCH"},
                "FETCH"
        ));

        questionSet.add(new API(
                "What is the default port for HTTP?",
                new String[]{"80", "8080", "443", "21"},
                "80"
        ));

        questionSet.add(new API(
                "What does the HTTP status code 201 indicate?",
                new String[]{"OK", "Created", "Bad Request", "Unauthorized"},
                "Created"
        ));

        questionSet.add(new API(
                "What header is used in REST APIs for authentication?",
                new String[]{"Content-Type", "Authorization", "Accept", "Cookie"},
                "Authorization"
        ));

        questionSet.add(new API(
                "Which architectural style do REST APIs follow?",
                new String[]{"Microservices", "Serverless", "Client-Server", "Event-Driven"},
                "Client-Server"
        ));

        Collections.shuffle(questionSet, new Random());

        return questionSet;
    }

    @Override
    public void addQuestionToSet(String question, String[] choices, String answer) {
        API newQuestion = new API(question,choices,answer);
        questionSet.add(newQuestion);
    }

}
