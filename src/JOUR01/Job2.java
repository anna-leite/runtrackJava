package JOUR01;

import java.util.Scanner;

public class Job2 {
    public static void PrintHelloName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name : ");
        String firstName = sc.nextLine();
        System.out.println("Hello " +firstName +"!");
    }
}
