import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

public class Job5 {
    public static void theLargestNumber() {
        float a = 0.0f;
        float b = 0.0f;
        float c = 0.0f;

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        boolean inputValid = false;

        while (!inputValid) {
            try {
                System.out.println("Enter three numbers : ");
                a = sc.nextFloat();
                b = sc.nextFloat();
                c = sc.nextFloat();

//                float largestNumber = 0.0f;
//                if (a > b && a > c) {
//                    largestNumber = a;
//                } else if (b > a && b > c) {
//                    largestNumber = b;
//                } else {
//                    largestNumber = c;
//                }

                float largestNumber = Math.max(a, Math.max(b, c));
                System.out.println("The largest number is : " + largestNumber);
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
