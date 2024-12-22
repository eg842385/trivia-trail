package Trivia_Trail.src.main.java;

import Trivia_Trail.src.main.java.GameLogic.QuizLogic;

public class Application {

    public static void main(String[] args) {
        QuizLogic gameLogic = new QuizLogic();
        gameLogic.run();
    }
}
