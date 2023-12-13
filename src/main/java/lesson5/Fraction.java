package lesson5;

import java.util.Scanner;
class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Fraction test = (Fraction) obj;
        return numerator * test.denominator == test.numerator * denominator;
    }




    public static Fraction consoleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть чисельник: ");
        int numerator = scanner.nextInt();
        System.out.print("Введіть знаменник: ");
        int denominator = scanner.nextInt();

        return new Fraction(numerator, denominator);
    }
}


