package lesson8;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Exception {

    public static class myException extends RuntimeException {
        public myException(String message) {
            super(message);
        }

    }

    public static void main(String[] args) {

        File file = new File("/Users/hordiienkod/Desktop/null.text");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            throw new myException("It's my custom exception!");
        } catch (myException e) {
            System.out.println("Handled: " + e.getMessage());
        }


    }

}



