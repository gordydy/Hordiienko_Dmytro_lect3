package lesson4;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] intArray = {1, 87, 900, 44, 0, -9};
        int temp;
        for (int i = 0; i < intArray.length - 1; i++) {
            for (int k = 0; k < intArray.length - i - 1; k++) {
                if (intArray[k] > intArray[k + 1]) {
                    temp = intArray[k];
                    intArray[k] = intArray[k + 1];
                    intArray[k + 1] = temp;
                }
            }
        }
        for (int num : intArray) {
            System.out.print(num + " ");
        }
    }
}




