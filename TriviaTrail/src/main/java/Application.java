package TriviaTrail.src.main.java;

import TriviaTrail.src.main.java.GameLogic.QuizLogic;

public class Application {

    public static void main(String[] args) {
        QuizLogic gameLogic = new QuizLogic();
        gameLogic.run();
    }
}
