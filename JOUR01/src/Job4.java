import java.util.InputMismatchException;
import java.util.Scanner;

public class Job4 {
    public static void printSquare() {
        Scanner sc = new Scanner(System.in);
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.println("Enter an integer number : ");
                int number = sc.nextInt();
                int square = number * number;
                System.out.println("The square of " + number + " is : " + square);
                inputValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            } finally {
                if (inputValid) {
                    sc.close(); // Close the scanner
                }
            }
        }
    }
}
