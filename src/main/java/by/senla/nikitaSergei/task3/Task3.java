package by.senla.nikitaSergei.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task3 {
    private static char[] arr = {'.', '!', '?'};


    // Line isn't a sentence. The sentence ends with one of symbols: "." or "!" or "?"
    private static String[] readStr() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Insert the line please!");
        try {
            String str = reader.readLine();
            String substring;
            int pos = str.length();
            for (char ch : arr) {
                int charPosition = str.indexOf(ch);
                if (charPosition > 0 && charPosition < pos)
                    pos = charPosition;
            }
            if (pos != str.length())
                substring = str.substring(0, pos);
            else {
                System.out.println("There is no sentence in this line!");
                return null;
            }
            return substring.split(" ");
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int wordsCounter(String[] mass) {
        return mass.length;
    }

    private static void toUpperCaseFistSymbol(String[] mass) {
        for (String str :
                mass) {
            System.out.print(str.substring(0, 1).toUpperCase() + str.substring(1) + " ");
        }
        System.out.println(" ");
    }

    private static void sortedWords(String[] mass) {
        Arrays.sort(mass);
        for (String str :
                mass) {
            System.out.print(str + " ");
        }
        System.out.println("");
    }

    public static void resultMethod() {
        String[] mass = readStr();
        if (mass != null) {
            System.out.println("This sentence contains " + wordsCounter(mass) + " words");
            System.out.print("This is a string of words whose first letters are uppercase: ");
            toUpperCaseFistSymbol(mass);
            System.out.print("This is a list of sorted words: ");
            sortedWords(mass);
        }
    }
}
