package by.senla.nikitaSergei;

import by.senla.nikitaSergei.task1.Task1;
import by.senla.nikitaSergei.task2.Task2;
import by.senla.nikitaSergei.task3.Task3;
import by.senla.nikitaSergei.task4.Task4;
import by.senla.nikitaSergei.task5.Task5;
import by.senla.nikitaSergei.task6.Task6;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello! This is my solution to the tasks. " +
                "To facilitate the verification of work, enter the number of the task you are interested in or enter 0 to exit the program!");
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number < 0 || number > 6) {
                    System.out.println("Invalid value entered. Try again");
                    sc = new Scanner(System.in);
                    continue;
                }
            } else {
                System.out.println("Invalid value entered. Try again");
                sc = new Scanner(System.in);
                continue;
            }
            switch (number) {
                case (1):
                    Task1.resultMethod();
                    break;
                case (2):
                    Task2.resultMethod();
                    break;
                case (3):
                    Task3.resultMethod();
                    break;
                case (4):
                    Task4.resultMethod();
                    break;
                case (5):
                    Task5.resultMethod();
                    break;
                case (6):
                    Task6.resultMethod();
                    break;
                default:
                    break;
            }
            if (number != 0) {
                System.out.println("To facilitate the verification of some else task, enter the number of the task you are interested in. ");
                sc = new Scanner(System.in);
                continue;
            } else return;
        }
    }
}
