package Algorithm;
import java.util.Scanner;
public class MergeSort {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a list of strings separated by spaces: ");
            String input = scanner.nextLine();
            String[] strings = input.split(" "); // split the input string into an array of strings
            mergeSort(strings, 0, strings.length - 1); // sort the strings using merge sort
            System.out.println("Sorted list: ");
            for (String string : strings) {
                System.out.print(string + " ");
            }
        }

        // Sort an array of strings using merge sort
        public static void mergeSort(String[] array, int lo, int hi) {
            if (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                mergeSort(array, lo, mid); // sort the left half of the array
                mergeSort(array, mid + 1, hi); // sort the right half of the array
                merge(array, lo, mid, hi); // merge the sorted halves of the array
            }
        }

        // Merge two sorted subarrays of the array
        public static void merge(String[] array, int lo, int mid, int hi) {
            String[] aux = new String[array.length];
            for (int i = lo; i <= hi; i++) {
                aux[i] = array[i];
            }
            int i = lo;
            int j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    array[k] = aux[j++];
                } else if (j > hi) {
                    array[k] = aux[i++];
                } else if (aux[j].compareTo(aux[i]) < 0) {
                    array[k] = aux[j++];
                } else {
                    array[k] = aux[i++];
                }
            }
        }
}
