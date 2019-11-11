package by.senla.nikitaSergei.task4;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {

    private static String textInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert the text please!");
        return reader.readLine();
    }

    private static String wordInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while (true) {
            System.out.println("Insert the word please!");
            word = reader.readLine();
            String[] arr = word.split(" ");
            if (arr.length > 1) {
                System.out.println("Error: Wrong input! Try again!");
                continue;
            } else return word.toLowerCase();
        }
    }

    public static void resultMethod() throws IOException {
        String text = textInput();
        String word = wordInput();
        String[] textArr = text.toLowerCase().split(" ");
        int result = Math.toIntExact(Arrays.stream(textArr).map(String::toLowerCase).filter(word::equals).count());
        System.out.println("The word \"" + word + "\" is contained in the text " + result + " times");
    }
}
