package TriviaTrail.src.main.java.Models;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    private List<String> categories = new ArrayList<>();

    public void loadCategoriesFromFile() {
        File file = new File("categories.txt");
        if (!file.exists()) {
            prepopulateCategories(file);
        }
        categories.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                categories.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading categories.");
            e.printStackTrace();
        }
    }

    private void prepopulateCategories(File file) {
        List<String> initialCategories = Arrays.asList("Genetics", "Java", "Database", "API");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileWriter writer = new FileWriter(file)) {
                for (String category : initialCategories) {
                    writer.write(category + "\n");
                }
            }
            System.out.println("Categories prepopulated successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while prepopulating categories.");
            e.printStackTrace();
        }
    }

    public void saveCategoriesToFile() {
        File file = new File("categories.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            try (FileWriter writer = new FileWriter(file)) {
                for (String category : categories) {
                    writer.write(category + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving categories.");
            e.printStackTrace();
        }
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void displayCategories() {
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ") " + categories.get(i));
        }
        System.out.println((categories.size() + 1) + ") Return to main menu");
    }

    public int lengthOfCategories() {
        return categories.size() + 1;
    }
}