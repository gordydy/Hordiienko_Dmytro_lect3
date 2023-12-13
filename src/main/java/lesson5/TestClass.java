package lesson5;
public class TestClass {

    public static void main(String[] args) {
        System.out.println("Введіть перший дріб:");
        Fraction fraction1 = Fraction.consoleInput();

        System.out.println("Введіть другий дріб:");
        Fraction fraction2 = Fraction.consoleInput();


        if (fraction1.equals(fraction2)) {
            System.out.println("Дроби рівні.");
        } else {
            System.out.println("Дроби не рівні.");
        }
    }
}

