package by.senla.nikitaSergei.task2;

import java.util.Scanner;

public class Task2 {

    private static int readNumber(String num) {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Please enter " + num + " number!");
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.println("Error: Wrong insert. It must be positive integer number! Try again!");
                sc.next();
            }
            number = sc.nextInt();
            if (number > 0)
                return number;
            else {
                System.out.println("Error: Wrong insert. It must be positive integer number! Try again!");
                continue;
            }
        }
    }

    private static int nod(int x, int y) {
        if (y == 0)
            return x;
        return nod(y, x % y);
    }

    private static int nok(int x, int y) {
        return x / nod(x, y) * y;

    }

    public static void resultMethod() {
        int x = readNumber("first");
        int y = readNumber("second");
        System.out.println("The greatest common factor of " + x + " and " + y + " is " + nod(x, y));
        System.out.println("The least common multiple of " + x + " and " + y + " is " + nok(x, y));
    }
}
