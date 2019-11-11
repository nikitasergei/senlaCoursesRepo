package by.senla.nikitaSergei.task1;

import java.util.Scanner;

public class Task1 {

    private static double readNumber() {
        Scanner sc = new Scanner(System.in);
        double number;
        System.out.println("Please enter a number!");
        while (!sc.hasNextDouble()) {
            System.out.println("Error: That not a number! Try again!");
            sc.next();
        }
        number = sc.nextDouble();
        return number;
    }

    //Number 0 is an even number (https://ru.wikipedia.org/wiki/%D0%9D%D0%BE%D0%BB%D1%8C)
    private static boolean isWholeNumber(double num) {
        return (num - Math.floor(num)) == 0;
    }

    private static boolean isEvenNumber(int num) {
        return num % 2 == 0;
    }

    private static boolean isSimpleNumber(int num) {
        if (num == 1)
            return false;
        if (num == 2)
            return true;
        else {
            int i = 3;
            if (isEvenNumber(num))
                return false;
            else {
                while (i * i <= num) {
                    if (num % i == 0)
                        return false;
                    else i = i + 2;
                }
                return true;
            }
        }
    }

    public static void resultMethod() {
        double checkingNumber = readNumber();
        if (isWholeNumber(checkingNumber)) {
            System.out.print("Number " + checkingNumber + " is a whole, ");
            int checkNumber = (int) checkingNumber;
            if (isEvenNumber(checkNumber)) {
                System.out.print("even and ");
            } else System.out.print("odd and ");
            if (isSimpleNumber(checkNumber))
                System.out.println("simple number");
            else System.out.println(("composite number"));
        } else System.out.println("Error: Was inserted a fractional number!!");
    }
}
