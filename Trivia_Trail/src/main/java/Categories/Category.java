package Trivia_Trail.src.main.java.Categories;

import java.util.ArrayList;

public class Category implements CategoryInterface {
    private int id;
    private String name;
    private static ArrayList<String> categories = new ArrayList<>();

    static  {
        categories.add("Genetics");
        categories.add("Java");
        categories.add("Databases");
        categories.add("APIs");
        categories.add("Exit");
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void displayCategories() {
        for(int i = 0; i < categories.size(); i++){
            System.out.println(i + 1 + ") " + categories.get(i));
        }
    }

    @Override
    public void addCategory(int id, String name) {
// logic to add here
    }



    public int lengthOfCategories(){
        return categories.size();
    }

}
