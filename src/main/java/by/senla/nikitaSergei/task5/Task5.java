package by.senla.nikitaSergei.task5;

import java.util.Scanner;

public class Task5 {

    public static void resultMethod() {
        System.out.println("Enter the length of the sequence: ");
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n < 0 || n > 100) {
                    System.out.println("Incorrect value entered! Try again");
                    sc = new Scanner(System.in);
                    continue;
                }
                break;
            }
        }
        int[] sequence = generateRandomSequence(n);
        for (int element : sequence) {
            System.out.print(element + " ");

        }
        System.out.println("");
        System.out.println("This sequence contains " + countPalindromes(sequence) + " palindrome");

    }

    private static int[] generateRandomSequence(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.round(Math.random() * 100000);
        }
        return arr;
    }

    private static int countPalindromes(int[] sequence) {
        int count = 0;
        for (int element : sequence) {
            if (checkElementInteger(element))   //or you can change this row    if (checkElementString(element))
                count++;
        }
        return count;
    }

    public static boolean checkElementInteger(int elem) {
        int tempElem = elem;
        int tempElement = 0;
        int length = Integer.toString(tempElem).length();
        while (length > 0) {
            tempElement = tempElement + (tempElem % 10) * (int) Math.pow(10, length - 1);
            tempElem = tempElem / 10;
            length--;
        }
        return tempElement == elem;
    }

    private static boolean checkElementString(int element) {
        String str = Integer.toString(element);
        int length = str.length();
        if (length > 1) {
            StringBuffer buffer = new StringBuffer(str);
            return str.contentEquals(buffer.reverse());
        } else return false;
    }
}
