package Trivia_Trail.src.main.java.Categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DB extends Question implements QuestionInterface{
    private List<Question> questionSet = new ArrayList<>();
    public DB(String question, String[] choices, String answer) {
        super(question, choices, answer);
    }

    public DB(){
        super();
    };

    public List<Question> questionSet() {

        questionSet.add(new DB(
                "Which SQL keyword is used to retrieve data from a database?",
                new String[]{"GET", "SELECT", "RETRIEVE", "FETCH"},
                "SELECT"
        ));

        questionSet.add(new DB(
                "Which SQL clause is used to filter the results of a query?",
                new String[]{"WHERE", "HAVING", "GROUP BY", "ORDER BY"},
                "WHERE"
        ));

        questionSet.add(new DB(
                "Which SQL command is used to delete data from a table?",
                new String[]{"DROP", "DELETE", "REMOVE", "TRUNCATE"},
                "DELETE"
        ));

        questionSet.add(new DB(
                "What type of SQL join returns all rows from the left table and matching rows from the right table?",
                new String[]{"INNER JOIN", "LEFT JOIN", "RIGHT JOIN", "FULL JOIN"},
                "LEFT JOIN"
        ));

        questionSet.add(new DB(
                "What does the SQL statement 'ALTER TABLE' do?",
                new String[]{"Delete a table", "Modify a table structure", "Create a new table", "Insert new rows into a table"},
                "Modify a table structure"
        ));

        questionSet.add(new DB(
                "What does a foreign key constraint do in SQL?",
                new String[]{"Ensures data integrity by linking two tables", "Enforces uniqueness of the column", "Ensures that the column has no null values", "Allows faster sorting of data"},
                "Ensures data integrity by linking two tables"
        ));

        questionSet.add(new DB(
                "Which of the following can be part of a composite primary key?",
                new String[]{"One or more columns", "Only integer columns", "Only text columns", "Only unique values"},
                "One or more columns"
        ));

        questionSet.add(new DB(
                "What is the main purpose of a PRIMARY KEY in a relational database?",
                new String[]{"To uniquely identify a row", "To store large amounts of data", "To create relationships between tables", "To filter data in a query"},
                "To uniquely identify a row"
        ));

        questionSet.add(new DB(
                "What is the default sorting order of the 'ORDER BY' clause in SQL?",
                new String[]{"Ascending", "Descending", "Random", "Unsorted"},
                "Ascending"
        ));

        questionSet.add(new DB(
                "Which SQL constraint is used to establish a relationship between two tables?",
                new String[]{"PRIMARY KEY", "FOREIGN KEY", "CHECK", "UNIQUE"},
                "FOREIGN KEY"
        ));

        questionSet.add(new DB(
                "Which SQL command is used to perform the 'Create' operation in the CRUD model?",
                new String[]{"SELECT", "INSERT", "UPDATE", "DELETE"},
                "INSERT"
        ));

        Collections.shuffle(questionSet, new Random());

        return questionSet;
    }

    @Override
    public void addQuestionToSet(String question, String[] choices, String answer) {
        DB newQuestion = new DB(question,choices,answer);
        questionSet.add(newQuestion);
    }


}
