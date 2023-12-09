package lesson4;

public class Triangle {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 5 - i; j > 0; j--) {
                System.out.print("  ");
            }
            int k = 1;
            while (k <= 2 * i - 1) {
                System.out.print("* " );
                k++;
            }

            System.out.println();
        }
    }
}
