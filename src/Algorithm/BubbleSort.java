package Algorithm;
import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a list of integers separated by spaces: ");
            String input = scanner.nextLine();
            String[] strings = input.split(" "); // split the input string into an array of strings
            int[] nums = new int[strings.length]; // create an array to hold the integers
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]); // convert each string to an integer and store it in the array
            }
            bubbleSort(nums); // sort the integers using bubble sort
            System.out.println("Sorted list: ");
            for (int num : nums) {
                System.out.print(num + " ");
            }
        }

        // Sort an array of integers using bubble sort
        public static void bubbleSort(int[] array) {
            boolean swapped;
            do {
                swapped = false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        swapped = true;
                    }
                }
            } while (swapped);
        }
}
