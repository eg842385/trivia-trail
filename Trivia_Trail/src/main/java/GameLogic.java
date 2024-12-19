package Trivia_Trail.src.main.java;

import Trivia_Trail.src.main.java.Categories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    private static final String MAIN_MENU_OPTION_ADD_QUESTION = "Add a Question";
    private static final String MAIN_MENU_OPTION_PLAY_GAME = "Select Trivia Category";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_ADD_QUESTION, MAIN_MENU_OPTION_PLAY_GAME, MAIN_MENU_OPTION_EXIT};
    private final Scanner scan = new Scanner(System.in);
    private Genetics genetics = new Genetics();
    private Java java = new Java();
    private DB database = new DB();
    private API api = new API();



    public void welcomeMessage() {
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("*** Welcome to Trivia Quest! ***");
        System.out.println("********************************");
        System.out.println("********************************");
    }

    public void printMainMenu() {

        for (int i = 0; i < MAIN_MENU_OPTIONS.length; i++) {

            System.out.println((i + 1) + ") " + MAIN_MENU_OPTIONS[i]);
        }
        System.out.print("\nPlease choose an option >>> ");
    }

    public void run() {
        boolean isRunning = true;
        System.out.println();
        welcomeMessage();
        System.out.println();

        while (isRunning) {
            printMainMenu();

            System.out.println();

            String userInput = scan.nextLine().trim();

            if (userInput.equals("1")) {
                // add question method

            } else if (userInput.equals("2")) {
                displayQuestions();

            } else if (userInput.equals("3")) {
                isRunning = false;
            }
        }
    }


    public void displayQuestions() {

        System.out.println();
        System.out.println("1) Genetics");
        System.out.println("2) Java");
        System.out.println("3) Databases");
        System.out.println("4) APIs");
        System.out.println();
        System.out.println("Choose a category>> ");

        int category = scan.nextInt();
        scan.nextLine();
        List<Question> triviaQuestions;

        if (category == 1) {
            triviaQuestions = genetics.questionSet(); // genetics questions
        } else if (category == 2) {
            triviaQuestions = java.questionSet(); //  java questions
        } else if (category==3) {
            triviaQuestions = database.questionSet(); //  databases questions
        } else if (category==4){
            triviaQuestions = api.questionSet(); //     api questions
        }else {
            System.out.println("Invalid choice!");
            return;
        }


        int numberCorrect = 0;

//        show questions from questionSet
        for (int question = 0; question < triviaQuestions.size(); question++) {

            System.out.println();
            System.out.println(triviaQuestions.get(question).getQuestion());
            int numChoices = triviaQuestions.get(question).getChoices().size();

//            show choices from questions in questionSet
            for (int choice = 0; choice < numChoices; choice++) {
                System.out.println((choice + 1) + ") " + triviaQuestions.get(question).getChoices().get(choice));
            }

            System.out.println("\nYour Answer: ");

            int userAnswer = scan.nextInt();
            scan.nextLine();

            ArrayList<String> choiceSet = triviaQuestions.get(question).getChoices();
            String correctAnswer = triviaQuestions.get(question).getAnswer();
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);

            if (userAnswer == (correctAnswerIndex + 1)) {
                numberCorrect++;
            }
        }

        System.out.println("You got " + (numberCorrect / triviaQuestions.size()) * 100 + "% correct!\n");

        // Prompt if the user wants to return to the main menu or play again
        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = scan.nextLine().trim().toLowerCase();
        if (playAgain.equals("no")) {
            System.out.println("Thanks for playing! Returning to the main menu...\n");
        } else if(playAgain.equals("yes")) {
            displayQuestions();
        } else {
            System.out.println("Please enter yes/no");
        }
    }
}
