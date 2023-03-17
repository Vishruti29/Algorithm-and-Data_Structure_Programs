package Algorithm;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WordSearch {

    public static void main(String[] args) {
        String filename = "wordlist.txt"; // the file containing the list of words
        String[] words = readWordsFromFile(filename); // read in the words from the file
        Arrays.sort(words); // sort the words in alphabetical order
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String searchWord = scanner.nextLine().toLowerCase();
        int index = Arrays.binarySearch(words, searchWord); // perform binary search
        if (index >= 0) {
            System.out.println("The word '" + searchWord + "' was found in the list.");
        } else {
            System.out.println("The word '" + searchWord + "' was not found in the list.");
        }
    }

    // Read in the list of words from a file
    public static String[] readWordsFromFile(String filename) {
        String[] words = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            if (line != null) {
                words = line.split(","); // split the words by comma
                for (int i = 0; i < words.length; i++) {
                    words[i] = words[i].trim().toLowerCase(); // remove leading/trailing spaces and convert to lowercase
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}