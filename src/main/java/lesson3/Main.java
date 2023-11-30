package lesson3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CurrencyConverter newCommission = new CurrencyConverter(0.01, 36.55);
        Scanner inputResult = new Scanner(System.in);
        System.out.println("Enter amount in dollars");
        if (inputResult.hasNextInt()) {
            double usd = inputResult.nextInt();
            if (usd > 0) {
                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formatted = decimalFormat.format(newCommission.calculateTotalAmount(usd));
                System.out.println(formatted);
            } else {
                System.out.println("Number can't be lowest than 0");
            }
        } else {
            System.out.println("Input must be a number");
            inputResult.close();
        }
    }
}
