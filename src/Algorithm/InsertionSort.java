package Algorithm;
import java.util.Scanner;
public class InsertionSort {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a list of words separated by spaces: ");
            String input = scanner.nextLine();
            String[] words = input.split(" "); // split the input string into an array of words
            insertionSort(words); // sort the words using insertion sort
            System.out.println("Sorted list: ");
            for (String word : words) {
                System.out.print(word + " ");
            }
        }

        // Sort an array of strings using insertion sort
        public static void insertionSort(String[] array) {
            for (int i = 1; i < array.length; i++) {
                String temp = array[i];
                int j = i - 1;
                while (j >= 0 && array[j].compareTo(temp) > 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
}
