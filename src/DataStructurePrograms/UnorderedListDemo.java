package DataStructurePrograms;
import java.io.*;
import java.util.*;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class UnorderedList<T> {
    Node<T> head;

    UnorderedList() {
        this.head = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
    }

    public boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(T data) {
        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.data.equals(data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void saveToFile(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        Node<T> current = head;

        while (current != null) {
            writer.write(current.data.toString() + " ");
            current = current.next;
        }

        writer.close();
    }
}

public class UnorderedListDemo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = scanner.nextLine();

        // Read words from file and add to list
        UnorderedList<String> list = new UnorderedList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        while (line != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                list.add(word);
            }
            line = reader.readLine();
        }
        reader.close();

        // Search for a word and remove it if found, add it if not found
        System.out.println("Enter a word to search: ");
        String word = scanner.nextLine();
        if (list.search(word)) {
            System.out.println("Word found. Removing from list.");
            list.remove(word);
        } else {
            System.out.println("Word not found. Adding to list.");
            list.add(word);
        }

        // Save the final list to a file
        System.out.println("Enter output file name: ");
        String outputFileName = scanner.nextLine();
        list.saveToFile(outputFileName);
        System.out.println("List saved to " + outputFileName);
    }
}
