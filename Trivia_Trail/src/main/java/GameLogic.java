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
        System.out.println();
        for (int i = 0; i < MAIN_MENU_OPTIONS.length; i++) {

            System.out.println((i + 1) + ") " + MAIN_MENU_OPTIONS[i]);
        }
        System.out.print("\nPlease choose an option >>> ");
    }

    public void run() {
        boolean isRunning = true;
        welcomeMessage();

        while (isRunning) {
            printMainMenu();
            String userInput = scan.nextLine().trim();

            switch(userInput){
                case "1":
                    addQuestion();
                    break;
                case "2":
                    displayQuestions();
                    break;
                case "3":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    public void displayQuestions() {

        System.out.println("\n1) Genetics");
        System.out.println("2) Java");
        System.out.println("3) Databases");
        System.out.println("4) APIs\n");
        System.out.print("Choose a category>> ");

        List<Question> triviaQuestions = null;

        while(true){
            int category = scan.nextInt();
            scan.nextLine();

            switch(category){
                case 1:
                    triviaQuestions = genetics.questionSet();
                    break;
                case 2:
                    triviaQuestions = java.questionSet();
                    break;
                case 3:
                    triviaQuestions = database.questionSet();
                    break;
                case 4:
                    triviaQuestions = api.questionSet();
                    break;
                default:
                    System.out.println("Invalid choice! Please select again.");
                    continue;
            }

            if (triviaQuestions != null) {
                break;
            }
        }

        int numberCorrect = 0;

//        show questions from questionSet
        for (Question question : triviaQuestions) {

            System.out.println("\n" + question.getQuestion());
            int numChoices = question.getChoices().size();

//            show choices from questions in questionSet
            for (int choice = 0; choice < numChoices; choice++) {
                System.out.println((choice + 1) + ") " + question.getChoices().get(choice));
            }

            System.out.print("\nYour Answer: ");

            int userAnswer = scan.nextInt();
            scan.nextLine();

            ArrayList<String> choiceSet = question.getChoices();
            String correctAnswer = question.getAnswer();
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer);

            if (userAnswer == (correctAnswerIndex + 1)) {
                numberCorrect++;
            }
        }

        System.out.printf("You got %.2f%% correct!\n", ((double) numberCorrect / triviaQuestions.size()) * 100);

        // Prompt if the user wants to return to the main menu or play again
        System.out.println("Do you want to play again? (yes/no)");

        while(true){
            String playAgain = scan.nextLine().trim().toLowerCase();
            if (playAgain.equals("no")) {
                System.out.println("Thanks for playing! Returning to the main menu...\n");
                break;
            } else if(playAgain.equals("yes")) {
                displayQuestions();
                break;
            } else {
                System.out.println("Please enter yes/no");
            }
        }
    }

    public void addQuestion(){

        System.out.println("\nWhich category would you like to add your question to?\n");
        System.out.println("1) Genetics");
        System.out.println("2) Java");
        System.out.println("3) Databases");
        System.out.println("4) APIs");
        System.out.println("5) Create a new category");
        System.out.println("0) Return to Main Menu");
        System.out.print("\nChoose a category>> ");

        int category = scan.nextInt();
        scan.nextLine();

        if(category == 0){
            return; // return to main menu
        }

        String newQ = getNewQuestion();
        String[] newChoices = getNewChoices();
        String newAnswer = getNewAnswer(newChoices);

        displayNewQuestion(newQ,newChoices,newAnswer);

        if(confirmQuestion()){
            addToCategory(category,newQ,newChoices,newAnswer);
        } else {
            System.out.println("Returning to add question menu...");
            addQuestion();
        }

    }

    public String getNewQuestion(){
        System.out.println("\nWhat is the question you would like to ask?");
         return scan.nextLine().trim();
    }

    public String[] getNewChoices() {
        System.out.println("\nHow about the options to answer this question? Separate the choices with a comma.");
        String input = scan.nextLine();
        String[] newChoices = input.split(",");
        for(int i = 0; i < newChoices.length; i++){
            newChoices[i] = newChoices[i].trim();
        }
        return newChoices;
    }

    public String getNewAnswer(String[] choices){
        System.out.println("\nWhich of those choices is the correct answer?");
        for(int i = 0; i < choices.length; i++){
            System.out.println(i+1 + ") "+ choices[i]);
        }
        System.out.print("Correct Answer: ");

        String newAnswer;
        while(true){
            int answerIndex = scan.nextInt() - 1;
            if(answerIndex >= 0 && answerIndex < choices.length){
                newAnswer = choices[answerIndex];
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        return newAnswer;
    }

    public void displayNewQuestion(String question, String[] choices, String answer){
        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("Question: " + question+"\n");
        System.out.println("Choices: ");
        for(int i = 0; i < choices.length; i++){
            System.out.println(i+1 + ") "+ choices[i]);
        }
        System.out.println("\nCorrect Answer: " + answer);
        System.out.println("------------------------------------------------------------------------------------------------");
    }

    public boolean confirmQuestion(){
        System.out.println("\nDoes this look correct? yes/no");
        scan.nextLine();

        while(true){
            String confirmQ = scan.nextLine().trim().toLowerCase();
            if (confirmQ.equals("no")) {
                return false;
            } else if(confirmQ.equals("yes")) {
                System.out.println("Adding your question...");
                return true;
            } else {
                System.out.println("Please enter yes/no");
            }
        }
    }

    public void addToCategory(int category, String question, String[] choices, String answer){
        switch(category){
            case 1:
                genetics.addQuestionToSet(question,choices,answer);
                break;
            case 2:
                java.addQuestionToSet(question,choices,answer);
                break;
            case 3:
                database.addQuestionToSet(question,choices,answer);
                break;
            case 4:
                api.addQuestionToSet(question,choices,answer);
                break;
            case 5:
                System.out.println("Coming soon....");;
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

}
