package Trivia_Trail.src.main.java.Categories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Genetics extends Question {

    public Genetics(String question, String[] choices, String answer) {
        super(question, choices, answer);
    }

    public static List<Question> questionSet() {
        ArrayList<Question> questionSet = new ArrayList<>();


        questionSet.add(new Genetics(
                "What is the shape of the DNA molecule?",
                new String[]{"Ladder", "Helix", "Double Helix", "Linear Spiral"},
                "Double Helix"
        ));

        questionSet.add(new Genetics(
                "What are the basic units of heredity in living organisms?",
                new String[]{"Genes", "Cells", "Chromosomes", "Proteins"},
                "Genes"
        ));

        questionSet.add(new Genetics(
                "Which of the following bases is NOT found in DNA?",
                new String[]{"Cytosine", "Adenine", "Guanine", "Uracil"},
                "Uracil"
        ));

        questionSet.add(new Genetics(
                "What is the name of the technique used to amplify small amounts of DNA?",
                new String[]{"CRISPR", "PCR (Polymerase Chain Reaction)", "Gel electrophoresis", "DNA sequencing"},
                "PCR (Polymerase Chain Reaction)"
        ));

        questionSet.add(new Genetics(
                "In humans, which genetic condition is associated with an extra copy of chromosome 18?", new String[]{"Turner syndrome", "Down syndrome", "Edward syndrome", "Klinefelter syndrome"}, "Edward syndrome"
        ));

        questionSet.add(new Genetics(
                "Which type of RNA carries the genetic code from DNA to the ribosome?",
                new String[]{"tRNA (transfer RNA)", "rRNA (ribosomal RNA)", "mRNA (messenger RNA)", "siRNA (small interfering RNA)"},
                "mRNA (messenger RNA)"
        ));

        questionSet.add(new Genetics(
                "Which scientist is labeled as the 'Father of Genetics'?",
                new String[]{"Gregory Mendel", "James Watson", "Francis Crick", "Charles Darwin"},
                "Gregory Mendel"
        ));

        questionSet.add(new Genetics(
                "What is the gene frequently associated with breast cancer?",
                new String[]{"CHEK2", "tp53", "BRCA", "MUTYH"},
                "BRCA"
        ));

        Collections.shuffle(questionSet, new Random());

        return questionSet;
    }
}
